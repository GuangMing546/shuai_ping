package com.gm.shuai_ping.util;

public class LoginData {
    private Integer id;
    private String role;
    private String userName;
    private String url;
    private String token;

    public LoginData() {
    }

    public LoginData(Integer id, String userName, String role, String token) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
