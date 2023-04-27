package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    List<Category> select();
}
