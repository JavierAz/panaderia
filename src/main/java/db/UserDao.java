package db;

import vw.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends DataBase {
    private final String findByCredentials = "SELECT * FROM Usuario where usuario = ? AND psw = ?";

    public User findUser(String usuario, String psw) {
        User u = null;
        try (Connection con = getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(findByCredentials)) {
                pst.setString(1, usuario);
                pst.setString(2, psw);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        u = new User();
                        u.setIdUsuario(rs.getInt("idUsuario"));
                        u.setUsuario(rs.getString("usuario"));
                        u.setPsw(rs.getString("psw"));
                    }
                }
            }
            disconnect();
        } catch (Exception e) {
            throw new RuntimeException("Error findByCredentials: ", e);
        }
        return u;
    }
}
