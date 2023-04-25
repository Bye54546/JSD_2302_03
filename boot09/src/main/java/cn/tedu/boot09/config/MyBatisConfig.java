package cn.tedu.boot09.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
//添加注解后工程启动时会自动扫描该类
@Configuration
@MapperScan("cn.tedu.boot09.mapper")
public class MyBatisConfig {

}
