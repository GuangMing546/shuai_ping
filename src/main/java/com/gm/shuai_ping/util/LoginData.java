package com.gm.shuai_ping.util;

public class LoginData {
    private Integer id;
    private String role;
    private String userName;
    private Integer signIn;
    private String url;
    private String token;

    @Override
    public String toString() {
        return "LoginData{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                ", signIn=" + signIn +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public LoginData() {
    }

    public LoginData(Integer id, String userName, String role, String token) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.token = token;
    }

    public Integer getSignIn() {
        return signIn;
    }

    public void setSignIn(Integer signIn) {
        this.signIn = signIn;
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
