package com.example.medicalsysbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.domain.Chat;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.domain.request.ChatRequest;
import com.example.medicalsysbackend.domain.vo.MessageVo;

import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【chat】的数据库操作Service
* @createDate 2024-06-06 20:07:15
*/
public interface ChatService extends IService<Chat> {

    List<Chat> findAllChatMessages();

    /**
     * 获取私聊聊天内容
     *
     * @param chatRequest
     * @param chatType
     * @param loginUser
     * @return
     */
    List<MessageVo> getPrivateChat(ChatRequest chatRequest, int chatType, User loginUser);
    /**
     * 获取缓存
     *
     * @param redisKey
     * @param id
     * @return
     */
    List<MessageVo> getCache(String redisKey, String id);
    /**
     * 保存缓存
     *
     * @param redisKey
     * @param id
     * @param messageVos
     */
    void saveCache(String redisKey, String id, List<MessageVo> messageVos);
    /**
     * 聊天记录映射
     *
     * @param fromId
     * @param toId
     * @param text
     * @param chatType
     * @param createTime
     * @return
     */
    MessageVo chatResult(Integer fromId, Long toId, String text, Integer chatType, Date createTime);

    /**
     * 获取大厅聊天纪录
     *
     * @param chatType
     * @param loginUser
     * @return
     */
    List<MessageVo> getHallChat(int chatType, User loginUser);

    /**
     * 删除key
     *
     * @param key
     * @param id
     */
    void deleteKey(String key, String id);
}
