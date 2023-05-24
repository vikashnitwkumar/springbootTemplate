package com.vikash.SpringBootTemplates.DatabaseConnectionImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Value("${database.type}")
    private String databaseType;

    @Bean
    public DatabaseConnection databaseConnection() {
        if ("mysql".equals(databaseType)) {
            return new MySQLConnection();
        } else if ("postgres".equals(databaseType)) {
            return new PostgresConnection();
        } else if ("oracle".equals(databaseType)) {
            return new OracleConnection();
        } else {
            throw new IllegalArgumentException("Invalid database.type value: " + databaseType);
        }
    }
}
