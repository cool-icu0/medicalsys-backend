package com.example.medicalsysbackend.chat;

import com.example.medicalsysbackend.chat.entity.ResultMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageUtils {
    public static String getMessage(boolean isSystemMessage, String fromName,  String date,Object message){
        try {
            ResultMessage result = new ResultMessage();
            result.setSystem(isSystemMessage);
            result.setMessage(message);
            result.setNowTime(date);
            if (fromName!=null){
                result.setFromName(fromName);
            }
            //把字符串转成json格式的字符串
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
