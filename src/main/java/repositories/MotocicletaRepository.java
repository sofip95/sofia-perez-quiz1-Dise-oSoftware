/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.quiz.DatabaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.MotocicletaDTO;

/**
 *
 * @author sofia
 */
public class MotocicletaRepository {

    public MotocicletaDTO findById(String id) throws SQLException {
        String query = "SELECT * FROM motocicleta WHERE id = '" + id + "'";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new MotocicletaDTO(
                        resultSet.getString("id"),
                        resultSet.getString("marca"),
                        resultSet.getInt("cilindraje"),
                        resultSet.getFloat("precio"),
                        resultSet.getString("color")
                );
            } else {
                return null;
            }
        }
    }

    public void save(MotocicletaDTO motocicleta) throws SQLException {
        String query = "INSERT INTO motocicleta(id,marca,cilindraje,precio,color) VALUES ('" + motocicleta.getId() + "', '" + motocicleta.getMarca() + "', '" + motocicleta.getCilindraje() + "', '" + motocicleta.getPrecio() + "', '" + motocicleta.getColor() + "')";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void update(MotocicletaDTO motocicleta) throws SQLException {
        String query = "UPDATE motocicleta SET marca = '" + motocicleta.getMarca()
                + "', cilindraje = " + motocicleta.getCilindraje()
                + ", precio = " + motocicleta.getPrecio()
                + ", color = '" + motocicleta.getColor()
                + "' WHERE id = '" + motocicleta.getId() + "'";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM motocicleta WHERE id = '" + id + "'";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
}
