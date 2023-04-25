package cn.tedu.boot7.entity;

public class Products {
    private Integer id;
    private String title;
    private Double price;
    private Integer num;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
