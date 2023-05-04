package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    List<Banner> select();

    void deleteById(int id);

    void insert(String url);

    Banner selectById(int id);

    String selectUrlById(Integer id);

    void update(Banner banner);
}
