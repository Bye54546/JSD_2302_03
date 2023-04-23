package cn.tedu.bt.controller;

import cn.tedu.bt.entity.Product;
import cn.tedu.bt.utils.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class BmiController {
    @RequestMapping("/bmi")
    public String bmi(double weight, double height)
    {
        double bmi = weight/(height*height);
        if(bmi<18.5){
            return "Underweight";}
        else if(bmi<25){
            return "Normal";}
        else if(bmi<30){
            return "Overweight";}
        else{
            return "Obese";}
    }
    @RequestMapping("/insert")
    public String insert(Product product) {
        System.out.println("product = " + product);
        try(Connection con= DBUtil.getConnection()){
            String sql = "insert into products values(null,?,?,?)";
//创建PreparedStatement对象用于执行SQL语句
            PreparedStatement ps = con.prepareStatement(sql);
//            替换掉SQL语句中的占位符（？）
            ps.setString(1, product.getTitle());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNum());
//            执行SQL语句
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "inserted";
    }

    @RequestMapping("/select")
    public String select() {
        String table = "<table border=>";
        //创建一个集合用于存放查询到的所有商品
        ArrayList<Product> list = new ArrayList<>();
        try(Connection con= DBUtil.getConnection()){
            String sql = "select * from products";
            //创建PreparedStatement对象用于执行SQL语句
            PreparedStatement ps = con.prepareStatement(sql);
            //执行SQL语句
            ResultSet rs = ps.executeQuery();
            //遍历结果集
            while (rs.next()){
                //创建一个商品对象用于存放当前遍历到的商品信息
                Product p = new Product();
                //将当前遍历到的商品信息存放到商品对象中
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getDouble("price"));
                p.setNum(rs.getInt("num"));
                //将商品对象存放到集合中
                list.add(p);
            }
            table+= "<caption>商品列表</caption><tr><th>id</th><th>name</th><th>price</th><th>num</th><th>Delete</th></tr>";
            for (Product p : list) {
                table += "<tr><td>" + p.getId() + "</td><td>" + p.getTitle() + "</td><td>" + p.getPrice() + "</td><td>" + p.getNum() + "</td>"+"<td><a href='delete?id="+p.getId()+"'>Delete</a></td></tr>";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        try(Connection con= DBUtil.getConnection()){
            String sql = "delete from products where id=?";
            //创建PreparedStatement对象用于执行SQL语句
            PreparedStatement ps = con.prepareStatement(sql);
            //替换掉SQL语句中的占位符（？）
            ps.setInt(1, id);
            //执行SQL语句
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "deleted";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        try (Connection con = DBUtil.getConnection()) {
            String sql="update products set title=?,price=?,num=? where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getNum());
            ps.setInt(4,product.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "updated!<a href='/select'>Back</a>";
    }
}
