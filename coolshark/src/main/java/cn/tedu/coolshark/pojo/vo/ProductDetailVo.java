package cn.tedu.coolshark.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductDetailVo {
    private Integer id;
    private String title;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private String url;
    private Integer viewCount; //浏览量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    @Override
    public String toString() {
        return "ProductDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", saleCount=" + saleCount +
                ", url='" + url + '\'' +
                ", viewCount=" + viewCount +
                ", created=" + created +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
