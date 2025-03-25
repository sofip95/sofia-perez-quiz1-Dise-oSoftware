/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import exceptions.InvalidMotocicletaDataException;
import java.sql.SQLException;
import model.MotocicletaDTO;
import repositories.MotocicletaRepository;
import validators.MotocicletaValidator;

/**
 *
 * @author sofia
 */
public class MotocicletaService {

    private MotocicletaRepository motocicletaRepository = new MotocicletaRepository();

    public MotocicletaDTO getMotocicletaById(String id) throws SQLException {
        return motocicletaRepository.findById(id);
    }

    public boolean createMotocicleta(String placa, String marca, int cilindraje, float precio, String color) throws
            SQLException, InvalidMotocicletaDataException {
        if (!MotocicletaValidator.validateMarca(marca) || !MotocicletaValidator.validateCilindraje(cilindraje) || !MotocicletaValidator.validatePrecio(precio) || !MotocicletaValidator.validateColor(color) || !MotocicletaValidator.validatePlaca(marca)) {

            throw new InvalidMotocicletaDataException("Datos inválidos");

        }
        MotocicletaDTO motocicleta = new MotocicletaDTO(placa, marca, cilindraje, precio, color);
        motocicletaRepository.save(motocicleta);
        return true;
    }

    public boolean updateMotocicleta(String id, String marca, int cilindraje, float precio, String color) throws
            SQLException, InvalidMotocicletaDataException {
        if (!MotocicletaValidator.validateMarca(marca)
                || !MotocicletaValidator.validateCilindraje(cilindraje)
                || !MotocicletaValidator.validatePrecio(precio)
                || !MotocicletaValidator.validateColor(color)) {

            throw new InvalidMotocicletaDataException("Datos inválidos");
        }

        MotocicletaDTO motocicletaExistente = motocicletaRepository.findById(id);
        if (motocicletaExistente == null) {
            throw new InvalidMotocicletaDataException("Motocicleta no encontrada");
        }

        MotocicletaDTO motocicletaActualizada = new MotocicletaDTO(id, marca, cilindraje, precio, color);
        motocicletaRepository.update(motocicletaActualizada);
        return true;
    }

    public boolean deleteMotocicleta(String id) throws SQLException, InvalidMotocicletaDataException {
        MotocicletaDTO motocicletaExistente = motocicletaRepository.findById(id);
        if (motocicletaExistente == null) {
            throw new InvalidMotocicletaDataException("Motocicleta no encontrada");
        }

        motocicletaRepository.delete(id);
        return true;
    }

}
