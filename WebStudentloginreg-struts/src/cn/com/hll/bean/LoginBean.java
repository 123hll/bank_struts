package cn.com.hll.bean;

public class LoginBean {
    private String username ;//用户名
    private String password;//密码
    private int shenfen;//用户身份

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getShenfen() {
        return shenfen;
    }
    public void setShenfen(int shenfen) {
        this.shenfen = shenfen;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
