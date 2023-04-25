package cn.teedu.boot08.controllor;

import cn.teedu.boot08.entity.Weibo;
import cn.teedu.boot08.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class weiboController {
    @Autowired
    WeiboMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo){
        mapper.insert(weibo);
    }
    @RequestMapping("/select")
    public List<Weibo> select(){
        return mapper.select();
    }
    @RequestMapping("/delete")
    public void delete(Integer id){
        String url = mapper.selectById(id);
        new File("E:/JSD_2302_03/boot08/src/main/resources/static/images/"+url).delete();
        mapper.deleteById(id);
    }
}
