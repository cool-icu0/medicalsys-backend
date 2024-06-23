package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Reply;
import com.example.medicalsysbackend.service.ReplyService;
import com.example.medicalsysbackend.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【reply】的数据库操作Service实现
* @createDate 2024-04-22 22:00:33
*/
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
    implements ReplyService{

    @Resource
    ReplyMapper replyMapper;

    @Override
    public List<Reply> selectAllReply() {
        return replyMapper.selectAllReply();
    }

    @Override
    public Reply selectReplyById(int reply_id) {
        return replyMapper.selectReplyById(reply_id);
    }

    @Override
    public List<Reply> selectReplyByTopicId(int topic_id) {
        return replyMapper.selectReplyByTopicId(topic_id);
    }

    @Override
    public int insertReply(Reply reply) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        reply.setReplyDate(d);
        return replyMapper.insertReply(reply);
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.updateReply(reply);
    }
}




