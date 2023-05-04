package cn.tedu.coolshark.pojo.vo;

import java.util.Date;

public class ProductIndexVo {
    private Integer id;
    private String title;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private String url;

    @Override
    public String toString() {
        return "ProductIndexVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", saleCount=" + saleCount +
                ", url='" + url + '\'' +
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
}
