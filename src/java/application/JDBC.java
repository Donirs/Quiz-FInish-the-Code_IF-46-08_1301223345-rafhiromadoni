/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author rafhi
 */
public class JDBC {

    Connection con;
    Statement stmt;
    public boolean isConnected;
    public String message;

    public JDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_quiz", "root", "");
            stmt = con.createStatement();
            isConnected = true;
            message = "DB Connected";
        } catch (Exception e) {
            isConnected = false;
            message = e.getMessage();
        }
    }

    public void disconnect() {
        try {
            stmt.close();
            con.close();
            message = "DB Disconnected";
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public void runUpdate(String query) {
        try {
            int result = stmt.executeUpdate(query);
            message = "info: " + result + " rows affected";
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public ResultSet runQuery(String query) {
        ResultSet result = null;
        try {
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            message = e.getMessage();
        }
        return result;

    }
}
