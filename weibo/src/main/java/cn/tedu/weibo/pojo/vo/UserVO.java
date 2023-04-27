package cn.tedu.weibo.pojo.vo;

public class UserVO {
    private Integer id;
    private String nickname;
    private String password;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return nickname;
    }

    public void setUsername(String username) {
        this.nickname = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
