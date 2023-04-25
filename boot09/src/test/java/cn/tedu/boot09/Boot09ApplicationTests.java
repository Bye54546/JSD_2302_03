package cn.tedu.boot09;

import cn.tedu.boot09.entity.Product;
import cn.tedu.boot09.mapper.ProductsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class Boot09ApplicationTests {
	@Autowired
	ProductsMapper mapper;

	@Test
	void contextLoads() {
		for (int i = 0; i < 20; i++) {
			Product p = new Product();
			p.setTitle("小米手机"+i);
			p.setPrice(1999.0);
			p.setNum(100);
			mapper.insert(p);
		}
	}

	@Test
	void select() {
		System.out.println(mapper.select());
	}

	@Test
	void deleteById() {
		mapper.deleteById(20);
	}
	@Test
	void update() {
		Product p = new Product();
		p.setId(21);
		p.setTitle("小米手机");
		p.setPrice(1999.0);
		p.setNum(100);
		mapper.update(p);
	}
	@Test
	void selectById() {
		System.out.println(mapper.selectById(21));
	}
	@Test
	void count(){
		System.out.println(mapper.count());
	}
	@Test
	void deleteByIds1() {
		Integer[] ids = {23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43};
		System.out.println(mapper.deleteByIds1(ids));
	}
	@Test
	void deleteById2(){
		ArrayList<Integer>list=new ArrayList<>();
		list.add(44);
		list.add(45);
		System.out.println(mapper.deleteByIds2(list));
	}
	@Test
	void deleteById3(){
		System.out.println(mapper.deleteByIds3(46, 47));
	}
	@Test
	void dynamicUpdate(){
		Product p = new Product();
		p.setId(63);
		p.setTitle("小米手机a+");
		p.setPrice(19.0);
		System.out.println(mapper.dynamicUpdate(p));
	}
}
