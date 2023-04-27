package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDto;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class commentController {
    @Autowired
    CommentMapper mapper;
    @RequestMapping("/insert")
    public int insert(@RequestBody CommentDto cDto, HttpSession session){
        if (user==null){
            return 2;
        }
        Comment c = new Comment();
        BeanUtils.copyProperties(CommentDto,c);
        c.setUserId(user.getId());
        c.setCreated(new Date());
        mapper.insert(c);
    }
    @RequestMapping("select")
    public List<CommentVo> select(int id){
        return mapper.selectWeiboId(id);
    }
}
