package cn.tedu.bt3mf.mapper;

import cn.tedu.bt3mf.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into products values (null,#{title},#{price},#{num})")
    int insert(Product product);

    @Delete("delete from product where id=#{id}")
    int delete(Product product);

    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    int update(Product product);

    @Select("select * from products")
    List<Product> select();
}
