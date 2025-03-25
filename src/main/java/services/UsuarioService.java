/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import exceptions.InvalidUsuarioDataException;
import java.sql.SQLException;
import model.UsuarioDTO;
import repositories.UsuarioRepository;
import validators.UsuarioValidator;

/**
 *
 * @author sofia
 */
public class UsuarioService {
        private UsuarioRepository usuarioRepository = new UsuarioRepository();
    
    public  UsuarioDTO getUsuarioById(int id) throws SQLException {
        return usuarioRepository.findById(id);
    }
    
    public boolean createUser(String nombre, String contrasenia) throws
            SQLException, InvalidUsuarioDataException {
        if (!UsuarioValidator.validateContrasenia(contrasenia) || !UsuarioValidator.validateName(nombre) ) {
            
            throw new InvalidUsuarioDataException("Datos inválidos");
           
        }
        UsuarioDTO usuario = new UsuarioDTO(0,nombre,contrasenia);
        usuarioRepository.save(usuario);
        return true;
    }
    
    public boolean login (String username, String password){
        return usuarioRepository.login(username, password);
    }
}
