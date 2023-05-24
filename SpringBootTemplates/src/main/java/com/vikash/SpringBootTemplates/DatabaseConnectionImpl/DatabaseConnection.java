package com.vikash.SpringBootTemplates.DatabaseConnectionImpl;

public interface DatabaseConnection {
    void connect();
    void save(Object data);
    void disconnect();
}
