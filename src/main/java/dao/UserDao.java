package dao;

import domain.User;

import java.sql.Connection;

public class UserDao {

  public User findUser(String usernams, String password) {
    try (Connection conn = DataSource.getConnection()) {
      //...
    } catch(Exception e) {
      throw new RuntimeException("Error finding user!", e);
    }

    return null;
  }
}
