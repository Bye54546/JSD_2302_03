package cn.tedu.weibo.pojo.entity;

import java.util.Date;

public class Weibo {
    private Integer id;
    private String content;
    private String urls;
    private Date created;
    private Integer userId;

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                '}';
    }

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

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
