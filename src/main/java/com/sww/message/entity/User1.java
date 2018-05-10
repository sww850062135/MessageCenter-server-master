package com.sww.message.entity;

public class User1 {
    private int id;
    private String username;
    private String phone;
    private String email;

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
