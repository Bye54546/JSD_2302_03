package cn.tedu.weibo.pojo.vo;

import javax.xml.crypto.Data;

public class WeiboMineVo {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getCreated() {
        return created;
    }

    public void setCreated(Data created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "WeiboMineVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }

    private Data created;
}
