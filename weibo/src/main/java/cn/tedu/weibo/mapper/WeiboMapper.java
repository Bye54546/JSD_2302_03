package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import org.springframework.stereotype.Repository;

@Repository
public interface WeiboMapper {
    int insert(Weibo weibo);
}
