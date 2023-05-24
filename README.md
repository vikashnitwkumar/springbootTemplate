# springbootTemplate

<!-- How to control the database dependency from application.properties.
To control the database dependency from the application.properties file, you can use Spring Boot's configuration features. Here's how you can achieve it:
Define the properties in application.properties: -->
# Database configuration 
database.type=mysql 
# database.type=postgres 
# database.type=oracle

<!-- Create an interface DatabaseConnection that defines the contract for the database operations: -->
public interface DatabaseConnection {
    void connect();
    void save(Object data);
    void disconnect();
}



<!-- Implement the DatabaseConnection interface for each specific database type: -->
@Service
public class MySQLConnection implements DatabaseConnection {
    // implementation for MySQL
}

@Service
public class PostgresConnection implements DatabaseConnection {
    // implementation for Postgres
}

@Service
public class OracleConnection implements DatabaseConnection {
    // implementation for Oracle
}

<!-- Modify the OrderProcessor class to use the configured database type: -->
public class OrderProcessor {
    private final DatabaseConnection connection;

    public OrderProcessor(DatabaseConnection connection) {
        this.connection = connection;
    }
    // ...
}




<!-- Create a configuration class that reads the database.type property and determines the appropriate bean to be injected: -->
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



<!-- 
By using the @Value annotation, the database.type property is read from the application.properties file. Based on the configured database type, the appropriate bean is created and injected into the OrderProcessor class using dependency injection.
Now, when you want to switch the database type, you can simply update the database.type property in the application.properties file, and Spring Boot will automatically wire the corresponding database connection bean accordingly.
Note: Make sure you have appropriate database dependencies added to your project, such as MySQL driver, Postgres driver, or Oracle driver, depending on the database you choose to use.
This approach allows you to control the database dependency from the application.properties file and provides flexibility in choosing the database type without modifying the code.

 -->
