package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.Topic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【topic】的数据库操作Service
* @createDate 2024-04-22 22:00:35
*/
public interface TopicService extends IService<Topic> {
    public List<Topic> selectAllTopic();
    public List<Topic> selectTopicByTitle(String title);
    public Topic selectTopicById(int topic_id);
    public int insertTopic(Topic topic) throws ParseException;
    public int updateTopic(Topic topic);
}
