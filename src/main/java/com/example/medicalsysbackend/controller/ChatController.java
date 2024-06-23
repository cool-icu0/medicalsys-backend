package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.domain.request.ChatRequest;
import com.example.medicalsysbackend.domain.vo.MessageVo;
import com.example.medicalsysbackend.service.ChatService;
import com.example.medicalsysbackend.service.UserService;
import com.example.medicalsysbackend.util.RedisCache;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.medicalsysbackend.constant.ChatConstant.HALL_CHAT;
import static com.example.medicalsysbackend.constant.ChatConstant.PRIVATE_CHAT;

@CrossOrigin
@Api(tags = "聊天信息控制类")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Resource
    private ChatService chatService;
    @Resource
    private RedisCache redisCache;
    @Resource
    private UserService userService;

//    @GetMapping("/select/chat")
//    public String getUsername(String userAccount, HttpSession httpsession) {
//        String username = userService.getUserByUserAccount(userAccount).getUsername();
//        //将用户名存储到session对象中
//        System.out.println(username + "---123123---" + httpsession);
//        if (username == null) {
//            return new ResponseResult(ErrorCode.NULL_ERROR).getMsg();
//        }
//        return username;
//    }
//    @GetMapping("/api/v1/chat")
//    public ResponseResult getChat() {
//        List<Chat> chatMessages = chatService.findAllChatMessages();
//        // 可以添加逻辑来转换或处理chatMessages数据
//        return new ResponseResult(200, "success", chatMessages);
//    }
    @PostMapping("/privateChat")
    public ResponseResult<List<MessageVo>> getPrivateChat(@RequestBody ChatRequest chatRequest, HttpServletRequest request) {
        if (chatRequest == null) {
            return new ResponseResult(ErrorCode.PARAMS_ERROR, "请求有误");
        }
        User loginUser = userService.getLoginUser(request);
//        System.out.println("loginUser："+loginUser);
        List<MessageVo> privateChat = chatService.getPrivateChat(chatRequest, PRIVATE_CHAT, loginUser);
        return new ResponseResult(ErrorCode.SUCCESS,privateChat);
    }

    @GetMapping("/hallChat")
    public ResponseResult<List<MessageVo>> getHallChat(HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        List<MessageVo> hallChat = chatService.getHallChat(HALL_CHAT, loginUser);
        return new ResponseResult(ErrorCode.SUCCESS,hallChat);
    }
}
