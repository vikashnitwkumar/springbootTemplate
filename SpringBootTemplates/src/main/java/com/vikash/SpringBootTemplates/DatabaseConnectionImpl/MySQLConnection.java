package com.vikash.SpringBootTemplates.DatabaseConnectionImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Service
public class MySQLConnection implements DatabaseConnection {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public MySQLConnection(
            @Value("${database.mysql.url}") String url,
            @Value("${database.mysql.username}") String username,
            @Value("${database.mysql.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create a connection to the MySQL database
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Object data) {
        try {
            // Prepare a SQL statement
            String sql = "INSERT INTO mytable (column1, column2) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameter values
            statement.setString(1, "value1");
            statement.setString(2, "value2");

            // Execute the SQL statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                // Close the database connection
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



