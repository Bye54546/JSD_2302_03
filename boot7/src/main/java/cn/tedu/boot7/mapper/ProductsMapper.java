package cn.tedu.boot7.mapper;

import cn.tedu.boot7.entity.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductsMapper {
    @Insert("insert into products values(null,#{title},#{price},#{num})")
    int insert(Products products);
    @Select("select * from products")
    List<Products> select();
    Products select(Products products);
    @Delete("delete from products where title=#{title}")
    void delete(Products products);
    @Update("update products set title=#{title},price=#{price},num=#{num} where id=#{id}")
    int update(Products products);
    @Select("select * from products where id=#{id}")
    Products selectById(int id);

}
