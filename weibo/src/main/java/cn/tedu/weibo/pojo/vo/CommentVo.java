package cn.tedu.weibo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CommentVo {
    private Integer id;
    private String content;
    @JsonFormat(pattern = "yyyy/mm/dd hh:mm:ss",timezone = "GMT+8")
    private Date created;
    private String nickname;

    @Override
    public String toString() {
        return "CommentVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
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
