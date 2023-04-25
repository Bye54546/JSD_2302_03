package cn.tedu.boot091.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot091.mapper")
public class MyBatisConfig {

}
