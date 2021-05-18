package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {

  Connection connection = null;

  protected Connection getConnection() throws SQLException {
    connection = DataSource.getConnection();

    return connection;
  }

  protected void disconnect() {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException("Error closing connection!", e);
    }
  }
}
