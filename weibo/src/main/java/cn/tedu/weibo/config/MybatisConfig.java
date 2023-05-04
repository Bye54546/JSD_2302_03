package cn.tedu.weibo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
//MybatisConfig是用来配置Mybatis的
@Configuration
@MapperScan("cn.tedu.weibo.mapper")
public class MybatisConfig {
}
