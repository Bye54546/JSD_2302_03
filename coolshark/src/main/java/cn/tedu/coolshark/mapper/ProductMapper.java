package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int insert(Product product);

    List<ProductAdminVo> selectForAdmin();

    String selectUrlById(int id);

    void deleteById(int id);

    ProductUpdateVo selectById(int id);

    void update(Product product);

    List<ProductTopVo> selectTop();
    List<ProductIndexVo> selectIndex();

    ProductDetailVo selectDetailById(int id);

    List<ProductIndexVo> selectCategoryById();

    List<ProductIndexVo> selectByWd(String wd);

    void updateViewCountById(int id);
}
