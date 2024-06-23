package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.sf.jsqlparser.statement.select.Top;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【topic】的数据库操作Mapper
* @createDate 2024-04-22 22:00:35
* @Entity generator.domain.Topic
*/
public interface TopicMapper extends BaseMapper<Topic> {

    @Select("select * from topic")
    public List<Topic> selectAllTopic();

    @Select("select * from topic where title LIKE concat('%',#{title},'%') ")
    public List<Topic> selectTopicByTitle(String title);

    @Select("select * from topic where topic_id = #{topicId}")
    public Topic selectTopicById(int topic_id);

    @Insert("INSERT INTO topic values(null, #{title},#{content},#{userId},#{createDate})")
    public int insertTopic(Topic topic);

    @Update("update topic set title = #{title}, content = #{content}, user_id = #{userId}, create_date = #{createDate} where topic_id = #{topicId}")
    public int updateTopic(Topic topic);
}




