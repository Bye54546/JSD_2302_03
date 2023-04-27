package cn.tedu.weibo.pojo.vo;

public class WeiboIndexVo {
    private Integer id;
    private String content;
    private String nickname;

    @Override
    public String toString() {
        return "WeiboIndexVo{" +
                "id=" + id +
                ", content='" + content + '\'' +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
