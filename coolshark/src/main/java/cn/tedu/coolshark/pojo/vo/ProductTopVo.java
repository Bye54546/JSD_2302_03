package cn.tedu.coolshark.pojo.vo;

public class ProductTopVo {
    private Integer id;
    private String title;
    private Integer saleCount;

    @Override
    public String toString() {
        return "ProductTopVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", saleCount=" + saleCount +
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

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
}
