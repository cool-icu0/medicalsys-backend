package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Reply;
import com.example.medicalsysbackend.domain.Topic;
import com.example.medicalsysbackend.service.ReplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/reply")
public class ReplyController {
    @Resource
    ReplyService replyService;

    @ApiOperation(value="查询所有话题的所有评论信息")
    @RequestMapping(value = "selectAllReply",method = RequestMethod.GET)
    public ResponseResult selectAllReply(){
        List<Reply> result= replyService.selectAllReply();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有话题的回复信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有话题的回复信息");
        }
    }

    @ApiOperation(value="根据话题名来查询话题的评论信息")
    @RequestMapping(value = "selectReplyByTopicId/{topicid}",method = RequestMethod.GET)
    public ResponseResult selectReplyByTopicId(@PathVariable int topicid){
        List<Reply> result= replyService.selectReplyByTopicId(topicid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询该话题的评论信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有评论信息");
        }
    }

    @ApiOperation(value="发布评论")
    @RequestMapping(value = "insertReply",method = RequestMethod.POST)
    public ResponseResult insertReply(@RequestBody Reply reply) throws ParseException {
        int result=replyService.insertReply(reply);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"评论成功",result);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"评论失败",result);

    }

    @ApiOperation(value="修改评论信息")
    @RequestMapping(value = "updateReply",method = RequestMethod.POST)
    public ResponseResult updateReply(@RequestBody Reply reply){
        int result=replyService.updateReply(reply);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"评论修改成功",result);
        else{
            Reply reply1 = replyService.selectReplyById(reply.getReplyId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"评论修改失败",reply1);
        }
    }

    @ApiOperation(value="分页显示评论")
    @GetMapping("/allReplyPager2")
    @CrossOrigin
    public Object allReplyPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Reply> list = replyService.selectAllReply();
        PageInfo<Reply> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }

}
