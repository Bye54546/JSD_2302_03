package cn.tedu.weibo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WeiboDetailVo {
    private Integer id;
    private String content;
    private String urls;
    @JsonFormat(pattern = "yyyy/mm/dd hh:mm:ss",timezone = "GMT+8")
    private Date created;
    private String nickname;

    @Override
    public String toString() {
        return "WeiboDetailVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", created=" + created +
                ", nickname='" + nickname + '\'' +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
