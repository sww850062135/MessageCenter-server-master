package com.sww.message.entity;

public class User {
    private int id;                 //主键
    private String username;        //账户名
    private String password;        //密码
    private String phone;           //手机号
    private String email;           //邮箱


    public User(int id, String username, String password, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
    public User(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("User{id:").append(this.id).append(",");
        stringBuffer.append("username:").append(this.username).append(",");
        stringBuffer.append("phone:").append(this.phone).append(",");
        stringBuffer.append("email:").append(this.email).append("}");
        return stringBuffer.toString();
    }
}
