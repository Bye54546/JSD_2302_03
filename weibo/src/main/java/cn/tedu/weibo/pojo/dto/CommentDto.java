package cn.tedu.weibo.pojo.dto;

public class CommentDto {
    private String content;
    private Integer weiboId;

    @Override
    public String toString() {
        return "CommentDto{" +
                "content='" + content + '\'' +
                ", weiboId=" + weiboId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }
}
