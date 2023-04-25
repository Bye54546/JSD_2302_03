package cn.tedu.boot091;

import cn.tedu.boot091.entity.Product;
import cn.tedu.boot091.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot091ApplicationTests {
@Autowired
ProductMapper mapper;
    @Test
    void contextLoads() {
        mapper.select();
    }
    @Test
    void insert(){
        Product p = new Product();
        p.setId(15);
        p.setTitle("冰冰");
        p.setPrice(50.5);
        p.setNum(1000);
    }
    @Test
    void delete(){
        mapper.deleteById(15);
    }
    @Test
    void update(){
        Product p = new Product();
        p.setId(15);
        p.setTitle("冰冰");
        p.setPrice(50.5);
        p.setNum(1000);
        mapper.update(p);
    }
}
