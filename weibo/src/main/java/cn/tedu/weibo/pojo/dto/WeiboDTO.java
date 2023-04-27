package cn.tedu.weibo.pojo.dto;

public class WeiboDTO {
    private String content;
    private String urls;

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

    @Override
    public String toString() {
        return "WeiboDTO{" +
                "content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                '}';
    }
}
