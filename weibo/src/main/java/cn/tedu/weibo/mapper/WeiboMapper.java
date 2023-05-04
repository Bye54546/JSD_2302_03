package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVo;
import cn.tedu.weibo.pojo.vo.WeiboIndexVo;
import cn.tedu.weibo.pojo.vo.WeiboMineVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeiboMapper {
    int insert(Weibo weibo);
    List<WeiboIndexVo> select();
    WeiboDetailVo selectById(int id);
    List<WeiboMineVo>selectMine(int id);
    void deleteById(int id);
}
