package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【reply】的数据库操作Mapper
* @createDate 2024-04-22 22:00:33
* @Entity generator.domain.Reply
*/
public interface ReplyMapper extends BaseMapper<Reply> {

    @Select("select * from reply")
    public List<Reply> selectAllReply();

    @Select("select * from reply where reply_id = #{replyId}")
    public Reply selectReplyById(int reply_id);

    @Select("select * from reply where topic_id = #{topic_id}")
    public List<Reply> selectReplyByTopicId(int topic_id);

    @Insert("INSERT INTO reply values(null, #{topicId},#{userId},#{content},#{replyDate})")
    public int insertReply(Reply reply);

    @Update("update reply set topic_id = #{topicId}, content = #{content}, user_id = #{userId}, reply_date = #{replyDate} where reply_id = #{replyId}")
    public int updateReply(Reply reply);
}




