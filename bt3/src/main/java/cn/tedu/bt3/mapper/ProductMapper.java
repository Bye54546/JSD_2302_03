package cn.tedu.bt3.mapper;

import cn.tedu.bt3.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//解决自动注入失败的问题
@Repository
@Mapper
public interface ProductMapper {
    @Insert("insert into products value(null,#{title},#{price},#{num})")
    int insert(Product product);

    //    执行insert语句后，会自动将id的值赋值给product对象
    @Select("select * from products")
    List<Product> select();

    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    int update(Product product);

    @Delete("delete from product where id=#{id}")
    int deleteById(Product product);
}
