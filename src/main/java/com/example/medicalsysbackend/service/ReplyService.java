package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【reply】的数据库操作Service
* @createDate 2024-04-22 22:00:33
*/
public interface ReplyService extends IService<Reply> {
    public List<Reply> selectAllReply();
    public Reply selectReplyById(int reply_id);
    public List<Reply> selectReplyByTopicId(int topic_id);
    public int insertReply(Reply reply) throws ParseException;
    public int updateReply(Reply reply);
}
