package cn.tedu.coolshark.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.coolshark.mapper")
public class MyBatisConfig {
}
