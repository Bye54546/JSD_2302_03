package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/banner/")
public class BannerController {
    @Value("${imagesPath}")
    private String dirPath;
    @Autowired
    BannerMapper mapper;
    @RequestMapping("select")
    public List<Banner> select(){
        return mapper.select();
    }
    @RequestMapping("delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

    @RequestMapping("insert")
    public void insert(String url){
        mapper.insert(url);
    }

    @RequestMapping("selectById")
    public Banner selectById(int id){
        return mapper.selectById(id);
    }
    @RequestMapping("update")
    public void update(@RequestBody Banner banner){
        //得到原来图片的路径
        String url = mapper.selectUrlById(banner.getId());
        //删除原来的图片
        new File(dirPath+url).delete();
        //修改
        mapper.update(banner);
    }


}
