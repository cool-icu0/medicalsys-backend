package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.domain.Topic;
import com.example.medicalsysbackend.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/topic")
public class TopicController {
    @Resource
    TopicService topicService;

    @ApiOperation(value="查询所有话题信息")
    @RequestMapping(value = "selectAllTopic",method = RequestMethod.GET)
    public ResponseResult selectAllTopic(){
        List<Topic> result= topicService.selectAllTopic();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有话题成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有话题信息");
        }
    }

    @ApiOperation(value="根据话题名来查询话题信息")
    @RequestMapping(value = "selectTopicByTitle/{title}",method = RequestMethod.GET)
    public ResponseResult selectTopicByTitle(@PathVariable String title){
        List<Topic> result= topicService.selectTopicByTitle(title);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询话题信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有话题信息");
        }
    }

    @ApiOperation(value="添加话题")
    @RequestMapping(value = "insertTopic",method = RequestMethod.POST)
    public ResponseResult insertTopic(@RequestBody Topic topic) throws ParseException {
        int result=topicService.insertTopic(topic);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"话题发布成功",topic);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"话题发布失败",topic);

    }

    @ApiOperation(value="修改话题信息")
    @RequestMapping(value = "updateTopic",method = RequestMethod.POST)
    public ResponseResult updateTopic(@RequestBody Topic topic){
        int result=topicService.updateTopic(topic);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"话题信息修改成功",topic);
        else{
            Topic topic1 = topicService.selectTopicById(topic.getTopicId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"话题信息修改失败",topic1);
        }
    }

    @ApiOperation(value="分页显示话题")
    @GetMapping("/allTopicPager2")
    @CrossOrigin
    public Object allTopicPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Topic> list = topicService.selectAllTopic();
        PageInfo<Topic> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }
}
