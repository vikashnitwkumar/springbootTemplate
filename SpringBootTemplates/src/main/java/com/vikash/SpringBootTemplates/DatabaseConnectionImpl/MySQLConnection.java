package com.vikash.SpringBootTemplates.DatabaseConnectionImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Service
public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {

    }

    @Override
    public void save(Object data) {

    }

    @Override
    public void disconnect() {

    }
}



