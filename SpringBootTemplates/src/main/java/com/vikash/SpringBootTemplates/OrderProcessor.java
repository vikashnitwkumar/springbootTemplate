package com.vikash.SpringBootTemplates;

import com.vikash.SpringBootTemplates.DatabaseConnectionImpl.DatabaseConnection;

public class OrderProcessor {
    private final DatabaseConnection connection;

    public OrderProcessor(DatabaseConnection connection) {
        this.connection = connection;
    }

    // ...
}
