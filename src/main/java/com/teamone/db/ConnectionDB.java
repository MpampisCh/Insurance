package com.teamone.db;

import java.sql.*;

public class ConnectionDB {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/insurance?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";
    private static Connection connection;

    static Connection getDBConnection() throws ExceptionDBLayer {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException exe) {
            throw new ExceptionDBLayer("DBConnection Fail !!!", exe);
        }
    }

    public static void closeDBConnection() throws ExceptionDBLayer {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exe) {
                throw new ExceptionDBLayer("DBConnection Fail !!!", exe);
            }
        }
    }

    public ConnectionDB() throws ExceptionDBLayer {
        try {
            connection = getDBConnection();
        } catch (Exception exe) {
            throw new ExceptionDBLayer("DBConnection Fail !!!", exe);
        }
    }

}
