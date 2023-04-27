package cn.tedu.coolshark.pojo.vo;

public class UserVo {
    private String password;
    private String nickname;

    @Override
    public String toString() {
        return "UserVo{" +
                "password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
