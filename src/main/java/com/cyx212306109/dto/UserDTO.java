package com.cyx212306109.dto;

public class UserDTO { // 注意：是DTO 不是 DT0（零）
    private String username;
    private String password;

    // Getter & Setter
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