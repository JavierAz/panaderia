package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private final String jdbcPassword = System.getenv("JDBC_PASSWORD");
    private final String jdbcURL = System.getenv("JDBC_URL");
    private final String jdbcDriver = System.getenv("JDBC_DRIVER");
    private final String jdbcUser = System.getenv("JDBC_USER");
    Connection connection;

    protected Connection getConnection() {
        try {
            try {
                Class.forName(jdbcDriver);
            } catch (ClassNotFoundException e) {
                System.out.println("Error al registrar driver de mysql: " + e);
            }

            connection = null;
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "test ok" : "test fail");

        } catch (SQLException sqlE) {
            System.out.println("Error: " + sqlE);
        }
        return null;
    }

    protected void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e);
        }
    }
}
