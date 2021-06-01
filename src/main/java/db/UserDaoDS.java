package db;

import vw.Person;
import vw.User;

import java.sql.*;

public class UserDaoDS {
    private final String findByCredentials = "SELECT * FROM Usuario where usuario = ? AND psw = ?";
    private final String insertPerson = "insert into Persona (Nombre, Paterno, Materno, CURP) VALUES (?, ?, ?, ?)";
    private final String insertUser = "insert into Usuario (IdPersona, usuario, psw) VALUES (?, ?, ?)";
    private final String getIdPersona = "select IdPersona from Persona where Nombre = ?";

    public User findUser(String usuario, String psw) {
        User u = null;
        try (Connection conn = DataSource.getConnection(); PreparedStatement pst = conn.prepareStatement(findByCredentials)) {
            pst.setString(1, usuario);
            pst.setString(2, psw);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("Nombre"));
                u.setPaterno(rs.getString("Paterno"));
                u.setMaterno(rs.getString("Materno"));
                u.setCurp(rs.getString("CURP"));
                u.setUsuario(rs.getString("usuario"));
                u.setPsw(rs.getString("psw"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error finByUser in UserDaoDS", e);
        }
        return u;
    }

    private Integer insertPerson(Person person) {
        String[] generatedKeys = new String[]{"idPersona"};
        try (Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(insertPerson, generatedKeys)) {
            pst.setString(1, person.getNombre());
            pst.setString(2, person.getPaterno());
            pst.setString(3, person.getMaterno());
            pst.setString(4, person.getCurp());
            int rs = pst.executeUpdate();
            ResultSet r = pst.getGeneratedKeys();
            r.next();
            return r.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException("Error insertPerson", e);
        }
    }

    public boolean insertUser(User user) {
        int idPerson = insertPerson(user);

        try (Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(insertUser)) {
            pst.setInt(1, idPerson);
            pst.setString(2, user.getUsuario());
            pst.setString(3, user.getPsw());

            if (pst.executeUpdate() == 1){
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error insertUser", e);
        }
        return false;
    }
}
