package cn.tedu.bt3;

import cn.tedu.bt3.entity.Product;
import cn.tedu.bt3.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bt3ApplicationTests {
@Autowired
ProductMapper mapper;
    @Test
    void contextLoads() {
        Product p = new Product();
        p.setTitle("冰茶");
        p.setPrice(2.5);
        p.setNum(100);
        System.out.println(mapper.insert(p));
    }
    @Test
    void select(){
        System.out.println(mapper.select());
    }
    @Test
    void update(){
        Product p = new Product();
        p.setId(2);
        p.setTitle("linlinlin");
        p.setNum(500);
        p.setPrice(6000.0);
    }
    @Test
    void delete(){
        Product p = new Product();
        p.setId(2);
        System.out.println(mapper.deleteById(p));

    }
}
