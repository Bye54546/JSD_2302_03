package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    List<Banner>select();
}
