/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import models.User;
import java.util.ArrayList;
import application.JDBC;
import java.sql.ResultSet;
import java.time.LocalDateTime; 
/**
 *
 * @author rafhi
 */
public class UserService {
    private JDBC db=new JDBC();
    public ArrayList<User> findAllUsers() {
        try{
            ResultSet rs = db.runQuery("select * from users;");
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String token = rs.getString("token");
                LocalDateTime token_expired_at = rs.getObject("token_expired_at", LocalDateTime.class);
                users.add(new User(id,username,password,token,token_expired_at));
            }
            return users;
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
            return null;
        }
    }
    public void saveUser(User user){
        try{
            db.runUpdate("insert into users (username,password) values ('"+user.getUsername()+"','"+user.getPassword()+"')");
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }
    
    public void updateUser(User user) {
        try {
            db.runUpdate("UPDATE users SET username = '" + user.getUsername() + "', password = '" + user.getPassword() + "' WHERE id = " + user.getId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public User findUserById(int id) {
        try {
            ResultSet rs = db.runQuery("SELECT * FROM users WHERE id = " + id);
            if (rs.next()) {
                int userId = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String token = rs.getString("token");
                LocalDateTime tokenExpiredAt = rs.getObject("token_expired_at", LocalDateTime.class);
                return new User(userId, username, password, token, tokenExpiredAt);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public User findUserByUsername(String username) {
        try {
            System.out.println("TEST: " +username);
            ResultSet rs = db.runQuery("SELECT * FROM users WHERE username = '" + username + "'");
            if (rs.next()) {
                int userId = rs.getInt("id");
                String password = rs.getString("password");
                String token = rs.getString("token");
                LocalDateTime tokenExpiredAt = rs.getObject("token_expired_at", LocalDateTime.class);
                return new User(userId, username, password, token, tokenExpiredAt);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void deleteUser(int id) {
        try {
            db.runUpdate("DELETE FROM users WHERE id = " + id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
