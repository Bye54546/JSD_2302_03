package cn.tedu.boot10.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.boot10.mapper")
public class MybatisConfig {
}
