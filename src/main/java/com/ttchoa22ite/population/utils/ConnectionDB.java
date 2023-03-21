package com.ttchoa22ite.population.utils;


import java.sql.*;

public class ConnectionDB {
    static Connection conn = null;



    public static Connection DAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demographic_management", "root", "");
            conn = con;
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Connect : "+ex.getMessage());
            return null;
        }
    }


}

