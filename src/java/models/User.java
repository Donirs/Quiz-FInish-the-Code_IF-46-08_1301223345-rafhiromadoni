/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author rafhi
 */
public class User {
    
    private int id;
    private String username, password, token;
    private LocalDateTime token_expired_at;

    public User(int id, String username, String password, String token, LocalDateTime token_expired_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.token_expired_at = token_expired_at;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setToken_expired_at(LocalDateTime token_expired_at) {
        this.token_expired_at = token_expired_at;
    }
    
    

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getToken_expired_at() {
        return token_expired_at;
    }
    
    
    
}
