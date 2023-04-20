package cn.tedu.bt.controller;

import cn.tedu.bt.entity.User;
import cn.tedu.bt.utils.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class UserController {
    @RequestMapping("/reg")
    public String reg(User user) {
        System.out.println("user = " + user);
        try(Connection con= DBUtil.getConnection()) {
            String sql = "select * from users where username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "username exists";
            }
            String insetSQL = "insert into users values(null,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(insetSQL);
            ps2.setString(1, user.getUsername());
            ps2.setString(2, user.getPassword());
            ps2.setString(3, user.getNickname());
            ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "reg success";
    }
    @RequestMapping("/login")
    public String login(User user) {
        System.out.println("user = " + user);
        try (Connection con = DBUtil.getConnection()) {
            String sql = "select * from users where username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pw = rs.getString(1);
                if (pw.equals(user.getPassword())) {
                    return "login success";
                }
                return "password error";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "username not exists";
    }
}
