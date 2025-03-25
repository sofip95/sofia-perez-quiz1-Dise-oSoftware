/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import org.mindrot.jbcrypt.BCrypt;
import com.mycompany.quiz.DatabaseConfig;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.UsuarioDTO;

/**
 *
 * @author sofia
 */
public class UsuarioRepository {

    public UsuarioDTO findById(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = " + id;
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new UsuarioDTO(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("contrasenia")
                );
            } else {
                return null;
            }
        }
    }

    public void save(UsuarioDTO usuario) throws SQLException {
        String hashedPassword = hashPassword(usuario.getContrasenia());
        String query = "INSERT INTO usuario(id,nombre,contrasenia) VALUES ('" + usuario.getId() + "', '" + usuario.getNombre() + "', '" + hashedPassword + "')";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public boolean login(String nombre, String contrasenia) {
        String query = "SELECT contrasenia FROM usuario WHERE nombre = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("contrasenia");

                return checkPassword(contrasenia, storedPasswordHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
