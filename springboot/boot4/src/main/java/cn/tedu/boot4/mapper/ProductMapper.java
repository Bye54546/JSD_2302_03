package cn.tedu.boot4.mapper;

import cn.tedu.boot4.entity.Products;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO products VALUES(NULL,#{title},#{price},#{num})")
    int insert(Products products);
    @Delete("DELETE FROM products WHERE id=#{id}")
    int deleteById(int id);
    @Update("UPDATE products SET title=#{title},price=#{price},num=#{num} WHERE id=#{id}")
    int update(Products products);
    @Select("select * from products")
    List<Products> select();
}
