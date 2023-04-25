package cn.tedu.boot091.mapper;

import cn.tedu.boot091.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {
    int insert(Product product);
    List<Product> select();
    int deleteById(int id);
    int update(Product product);
}
