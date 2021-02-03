package com.vastika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDb {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String SQL = "create database java10_db";

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement st = null;

        try {
            //1. Register the driver
            Class.forName(DRIVER);
            //2. obtain the connection object
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //3. obtain the statement object
            st = con.createStatement();
            //4.execute the query
            st.executeUpdate(SQL);
            System.out.println("db created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
