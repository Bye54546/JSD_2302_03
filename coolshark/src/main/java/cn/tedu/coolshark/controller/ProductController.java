package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.Dto.ProductDto;
import cn.tedu.coolshark.pojo.Dto.ProductUpdateDto;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {
    @Value("${imagesPath}")
    private String dirPath;
    @Autowired
    ProductMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody ProductDto productDto){
        System.out.println("productDto = " + productDto);
        //把dto数据装进entity
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        product.setCreated(new Date());
        product.setViewCount(0);
        //创建ProductMapper  实现insert方法
        mapper.insert(product);
    }

    @RequestMapping("select")
    public List<ProductAdminVo> select(){

        return mapper.selectForAdmin();
    }
    @RequestMapping("delete")
    public void delete(int id){
        String url = mapper.selectUrlById(id);
        new File(dirPath+url).delete();
        mapper.deleteById(id);

    }
    @RequestMapping("selectById")
    public ProductUpdateVo selectById(int id){
        return mapper.selectById(id);
    }
    @RequestMapping("update")
    public void update(@RequestBody ProductUpdateDto productUpdateDto){

        //得到原来图片的路径
        String url = mapper.selectUrlById(productUpdateDto.getId());
        //判断原来的路径和新的路径是否一致
        if (!url.equals(productUpdateDto.getUrl())){
            new File(dirPath+url).delete();//删除文件
        }

        //增和改时需要将dto转成entity
        Product product = new Product();
        BeanUtils.copyProperties(productUpdateDto,product);

        mapper.update(product);
    }
    @RequestMapping("/top")
    public List<ProductTopVo> top(){
        return mapper.selectTop();
    }
    @RequestMapping("index")
    public List<ProductIndexVo>index(){
        return mapper.selectIndex();
    }

    @RequestMapping("/detail")
    public ProductDetailVo detail(int id, HttpSession session) {
        String info=(String)session.getAttribute("view"+id);
        if (info==null){
//这个session的作用：当用户访问一个商品详情时，会在session中记录一下，这样当用户刷新页面时，就不会再增加浏览量了
//            setAttribute("view"+id,"visited")，这个visited是随便起的名字，只要不重复就行,需要在前面加上view，因为session中的key不能重复
//            setAttribute是设置session的值，getAttribute是获取session的值
            mapper.updateViewCountById(id);
            session.setAttribute("view"+id,"visited");
        }

        return mapper.selectDetailById(id);
    }
    @RequestMapping("category")
    public List<ProductIndexVo>category(int id){
        return mapper.selectCategoryById();
    }
    @RequestMapping("/search")
    public List<ProductIndexVo>search(String wd){
        return mapper.selectByWd(wd);
    }
}
