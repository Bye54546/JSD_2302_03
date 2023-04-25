package cn.tedu.boot071.mapper;

import cn.tedu.boot071.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO product VALUES(NULL,#{title},#{price},#{num})")
    int insert(Product product);
    @Select("SELECT * FROM product")
    List<Product> select();

}
