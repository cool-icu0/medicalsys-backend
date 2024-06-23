package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Topic;
import com.example.medicalsysbackend.service.TopicService;
import com.example.medicalsysbackend.mapper.TopicMapper;
import net.sf.jsqlparser.statement.select.Top;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【topic】的数据库操作Service实现
* @createDate 2024-04-22 22:00:35
*/
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic>
    implements TopicService{
    @Resource
    TopicMapper topicMapper;
    @Override
    public List<Topic> selectAllTopic() {
        return topicMapper.selectAllTopic();
    }

    @Override
    public List<Topic> selectTopicByTitle(String title) {
        return topicMapper.selectTopicByTitle(title);
    }

    @Override
    public Topic selectTopicById(int topic_id) {
        return topicMapper.selectTopicById(topic_id);
    }

    @Override
    public int insertTopic(Topic topic) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        topic.setCreateDate(d);
        return topicMapper.insertTopic(topic);
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }
}




