package cn.tedu.bt3mf;

import cn.tedu.bt3mf.entity.Product;
import cn.tedu.bt3mf.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bt3mfApplicationTests {
    @Autowired
    ProductMapper mapper;

    @Test
    void contextLoads() {
        Product p = new Product();
        p.setId(10);
        p.setNum(50);
        p.setPrice(2.2);
        p.setTitle("asdasd");
    }
    @Test
    void delete(){
        Product p = new Product();
        p.setId(10);
        System.out.println(mapper.delete(p));
    }
    @Test
    void update(){
        Product p = new Product();
        p.setId(2);
        p.setPrice(55.0);
        p.setNum(10);
        p.setTitle("爱搜书年底");
    }
    @Test
    void select(){
        System.out.println(mapper.select());
    }
}
