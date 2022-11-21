package com.liceu.dungeon_server.DAO.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabase {
    static Connection connection;

    public static Connection getConnection(){
        if (connection != null) return connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/MazeServer", "root", "root");
            return connection;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}