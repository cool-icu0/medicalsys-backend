package com.example.medicalsysbackend.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Chat;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.domain.request.ChatRequest;
import com.example.medicalsysbackend.domain.vo.MessageVo;
import com.example.medicalsysbackend.domain.vo.WebSocketVo;
import com.example.medicalsysbackend.mapper.ChatMapper;
import com.example.medicalsysbackend.service.ChatService;
import com.example.medicalsysbackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.example.medicalsysbackend.constant.ChatConstant.CACHE_CHAT_HALL;
import static com.example.medicalsysbackend.constant.ChatConstant.CACHE_CHAT_PRIVATE;
//import static com.example.medicalsysbackend.constant.ChatConstant.ADMIN_ROLE;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {

    private static final Integer ADMIN_ROLE = 3;
    @Resource
    private ChatMapper chatMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserService userService;
    @Override
    public List<Chat> findAllChatMessages() {
        return chatMapper.findAll();
    }



    @Override
    public List<MessageVo> getPrivateChat(ChatRequest chatRequest, int chatType, User user) {
        Long toId = chatRequest.getToId();
        System.out.println("toId:"+toId);
        List<MessageVo> chatRecords = getCache(CACHE_CHAT_PRIVATE, user.getUserId() + "" + toId);
        System.out.println("chatRecords："+chatRecords);
        if (chatRecords != null) {
            saveCache(CACHE_CHAT_PRIVATE, user.getUserId() + "" + toId, chatRecords);
            return chatRecords;
        }
        LambdaQueryWrapper<Chat> chatLambdaQueryWrapper = new LambdaQueryWrapper<>();
        chatLambdaQueryWrapper.
                and(privateChat -> privateChat.eq(Chat::getFromId, user.getUserId()).eq(Chat::getToId, toId)
                        .or().
                        eq(Chat::getToId, user.getUserId()).eq(Chat::getFromId, toId)
                ).eq(Chat::getChatType, chatType);
        System.out.println("chatLambdaQueryWrapper："+chatLambdaQueryWrapper);
        // 两方共有聊天
        List<Chat> list = this.list(chatLambdaQueryWrapper);
        List<MessageVo> messageVoList = list.stream().map(chat -> {
            MessageVo messageVo = chatResult(user.getUserId(), toId, chat.getText(), chatType, chat.getCreateTime());
            if (chat.getFromId().equals(user.getUserId())) {
                messageVo.setIsMy(true);
            }
            return messageVo;
        }).collect(Collectors.toList());
        saveCache(CACHE_CHAT_PRIVATE, user.getUserId() + "" + toId, messageVoList);
        return messageVoList;
    }
    @Override
    public MessageVo chatResult(Integer userId, Long toId, String text, Integer chatType, Date createTime) {
        MessageVo messageVo = new MessageVo();
        User fromUser = userService.getById(userId);
        User toUser = userService.getById(toId);
        WebSocketVo fromWebSocketVo = new WebSocketVo();
        WebSocketVo toWebSocketVo = new WebSocketVo();
        BeanUtils.copyProperties(fromUser, fromWebSocketVo);
        BeanUtils.copyProperties(toUser, toWebSocketVo);
        messageVo.setFormUser(fromWebSocketVo);
        messageVo.setToUser(toWebSocketVo);
        messageVo.setChatType(chatType);
        messageVo.setText(text);
        messageVo.setCreateTime(DateUtil.format(createTime, "yyyy年MM月dd日 HH:mm:ss"));
        return messageVo;
    }

    @Override
    public List<MessageVo> getHallChat(int chatType, User user) {
        List<MessageVo> chatRecords = getCache(CACHE_CHAT_HALL, String.valueOf(user.getUserId()));
        if (chatRecords != null) {
            List<MessageVo> messageVos = checkIsMyMessage(user, chatRecords);
            saveCache(CACHE_CHAT_HALL, String.valueOf(user.getUserId()), messageVos);
            return messageVos;
        }
        LambdaQueryWrapper<Chat> chatLambdaQueryWrapper = new LambdaQueryWrapper<>();
        chatLambdaQueryWrapper.eq(Chat::getChatType, chatType);
        List<MessageVo> messageVos = returnMessage(user, null, chatLambdaQueryWrapper);
        saveCache(CACHE_CHAT_HALL, String.valueOf(user.getUserId()), messageVos);
        return messageVos;
    }

    @Override
    public void deleteKey(String key, String id) {
        if (key.equals(CACHE_CHAT_HALL)) {
            redisTemplate.delete(key);
        } else {
            redisTemplate.delete(key + id);
        }
    }

    private List<MessageVo> checkIsMyMessage(User user, List<MessageVo> chatRecords) {
        return chatRecords.stream().peek(chat -> {
            if (chat.getFormUser().getId() != user.getUserId() && chat.getIsMy()) {
                chat.setIsMy(false);
            }
            if (chat.getFormUser().getId() == user.getUserId() && !chat.getIsMy()) {
                chat.setIsMy(true);
            }
        }).collect(Collectors.toList());
    }
    private List<MessageVo> returnMessage(User user, Long userId, LambdaQueryWrapper<Chat> chatLambdaQueryWrapper) {
        List<Chat> chatList = this.list(chatLambdaQueryWrapper);
        return chatList.stream().map(chat -> {
            MessageVo messageVo = chatResult(chat.getFromId(), chat.getText());
            boolean isCaptain = userId != null && userId.equals(chat.getFromId());
            if (userService.getById(chat.getFromId()).getRole() == ADMIN_ROLE || isCaptain) {
                messageVo.setIsAdmin(true);
            }
            if (chat.getFromId().equals(user.getUserId())) {
                messageVo.setIsMy(true);
            }
            messageVo.setCreateTime(DateUtil.format(chat.getCreateTime(), "yyyy年MM月dd日 HH:mm:ss"));
            return messageVo;
        }).collect(Collectors.toList());
    }
    /**
     * Vo映射
     *
     * @param userId
     * @param text
     * @return
     */
    public MessageVo chatResult(Long userId, String text) {
        MessageVo messageVo = new MessageVo();
        User fromUser = userService.getById(userId);
        WebSocketVo fromWebSocketVo = new WebSocketVo();
        BeanUtils.copyProperties(fromUser, fromWebSocketVo);
        messageVo.setFormUser(fromWebSocketVo);
        messageVo.setText(text);
        return messageVo;
    }

    /**
     * 获取缓存
     *
     * @param redisKey
     * @param id
     * @return
     */
    @Override
    public List<MessageVo> getCache(String redisKey, String id) {
        ValueOperations<String, List<MessageVo>> valueOperations = redisTemplate.opsForValue();
        List<MessageVo> chatRecords;
        if (redisKey.equals(CACHE_CHAT_HALL)) {
            chatRecords = valueOperations.get(redisKey);
        } else {
            chatRecords = valueOperations.get(redisKey + id);
        }
        return chatRecords;
    }
    /**
     * 保存缓存
     *
     * @param redisKey
     * @param id
     * @param messageVos
     */
    @Override
    public void saveCache(String redisKey, String id, List<MessageVo> messageVos) {
        try {
            ValueOperations<String, List<MessageVo>> valueOperations = redisTemplate.opsForValue();
            // 解决缓存雪崩
            int i = RandomUtil.randomInt(2, 3);
            if (redisKey.equals(CACHE_CHAT_HALL)) {
                valueOperations.set(redisKey, messageVos, 2 + i / 10, TimeUnit.MINUTES);
            } else {
                valueOperations.set(redisKey + id, messageVos, 2 + i / 10, TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            log.error("redis set key error");
        }
    }
}
