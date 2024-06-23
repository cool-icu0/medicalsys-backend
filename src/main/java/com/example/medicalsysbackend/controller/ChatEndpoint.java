//package com.example.medicalsysbackend.controller;
//
//import com.example.medicalsysbackend.chat.MessageUtils;
//import com.example.medicalsysbackend.chat.entity.ClientMessage;
//import com.example.medicalsysbackend.common.ErrorCode;
//import com.example.medicalsysbackend.config.HttpSessionConfigurator;
//import com.example.medicalsysbackend.domain.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Scope;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static com.example.medicalsysbackend.chat.ChatConstant.USER_LOGIN_STATE;
//
//@ServerEndpoint(value = "/chat",configurator = HttpSessionConfigurator.class)
//@Component
//@Scope("prototype")
//@Slf4j
//public class ChatEndpoint {
//
//
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 用来存储每个用户客户端对象的ChatEndpoint对象
//     */
//    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();
//
//    /**
//     * 声明session对象，通过对象可以发送消息给指定的用户
//     */
//    private Session session;
//
//    /**
//     * 声明HttpSession对象，我们之前在HttpSession对象中存储了用户名
//     */
//    private HttpSession httpSession;
//
//    //连接建立
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config){
//        this.session = session;
//        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        this.httpSession = httpSession;
//        //存储登陆的对象
//        User attribute =(User)httpSession.getAttribute(USER_LOGIN_STATE);
//        String username = attribute.getUsername();
//        onlineUsers.put(username,this);
//        log.info("websocket连接已建立！");
//    }
//
//    //收到消息
//    @OnMessage
//    public void onMessage(Session session,String message){
//        log.info("websocket消息: 收到客户端消息:" + message);
//        //将数据转换成对象
//        try {
//            ObjectMapper mapper =new ObjectMapper();
//            ClientMessage mess = mapper.readValue(message, ClientMessage.class);
//            String toName = mess.getToName();
//            String data = mess.getMessage();
//            log.info("websocket消息: toName:" + toName);
//            log.info("websocket消息: 数据:" + data);
//            log.info("websocket消息: 异常:" + onlineUsers.toString());
//            User attribute =(User)httpSession.getAttribute(USER_LOGIN_STATE);
//            String username = attribute.getUsername();
//            log.info("websocket消息: 用户:" + username);
//            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
//            String resultMessage = MessageUtils.getMessage(false, username,date, data);
//            //发送数据
//            log.info("websocket消息: 异常:" + resultMessage);
//            ChatEndpoint chatEndpoint = onlineUsers.get(toName);
//            if (chatEndpoint==null){
//                System.out.println(ErrorCode.PARAMS_ERROR+"该用户不在线!");
//            }
//            onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    //关闭
//    @OnClose
//    public void onClose(Session session) {
//
//        User attribute =(User)httpSession.getAttribute(USER_LOGIN_STATE);
//        String username = attribute.getUsername();
//        //从容器中删除指定的用户
//        onlineUsers.remove(username);
//        log.info("websocket连接已关闭！");
//    }
//}