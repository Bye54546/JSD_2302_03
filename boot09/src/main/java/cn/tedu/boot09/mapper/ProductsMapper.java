package cn.tedu.boot09.mapper;

import cn.tedu.boot09.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsMapper {
    int insert(Product product);
    List<Product>select();
    int deleteById(int id);
    int update(Product product);
    List<Product>selectById(int id);
    int count();
//    批量删除1
    int deleteByIds1(Integer[] ids);
//    批量删除2
    int deleteByIds2(List<Integer>ids);
//    批量删除3
    int deleteByIds3(Integer... ids);
    int dynamicUpdate(Product product);
}
