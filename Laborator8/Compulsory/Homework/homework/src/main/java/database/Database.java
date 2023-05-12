package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/playlist";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private Database() {}

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
       // con.setAutoCommit(false);
        return con;
    }
    private static void createConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println();
        }
    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() {
    }
}
