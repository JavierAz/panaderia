package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

  private static HikariConfig config = new HikariConfig();
  private static HikariDataSource ds;

  static {
    config.setJdbcUrl( System.getenv("JDBC_URL") );
    config.setUsername( "database_username" );
    config.setPassword( "database_password" );
    config.addDataSourceProperty("validationTimeout", 5000);
    ds = new HikariDataSource( config );
  }

  private DataSource() {}

  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }

  public static void disconnect(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException("Error closing connection!", e);
    }
  }
}
