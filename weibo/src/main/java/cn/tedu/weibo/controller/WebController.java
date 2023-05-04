package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.ResultVo;
import cn.tedu.weibo.pojo.vo.UserVO;
import cn.tedu.weibo.pojo.vo.WeiboDetailVo;
import cn.tedu.weibo.pojo.vo.WeiboIndexVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/weibo/")
public class WebController {
    @Autowired
    WeiboMapper mapper;
    @RequestMapping("insert")
    public int insert(@RequestBody WeiboDTO wDTO, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user==null){
            return 2;//代表未登录
        }
        //往数据库里面存的时候需要使用entity
        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(wDTO,weibo);
        //给weibo对象的其它属性赋值
        weibo.setUserId(user.getId());//设置当前登录的用户id为 微博的作者id
        weibo.setCreated(new Date());
        mapper.insert(weibo);
        return 1;
    }
    @RequestMapping("select")
    public List<WeiboIndexVo> select(){
    return mapper.select();
    }
    @RequestMapping("selectById")
    public WeiboDetailVo selectById(int id){
        return mapper.selectById(id);
    }
    @RequestMapping("select/mine")
    public ResultVo selectMine(HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");
        if (user==null){
            return new ResultVo(2,"用户未登录",null);
        }
        return new ResultVo(1,"请求成功",mapper.selectMine(user.getId()));
    }
    @Autowired
    CommentMapper commentMapper;
    @RequestMapping("delete")
    public void delete(int id){
        commentMapper.deleteByWeiboId(id);
        mapper.deleteById(id);
    }

}

