package cn.tedu.coolshark.pojo.Dto;

public class UserDto {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserVo{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
