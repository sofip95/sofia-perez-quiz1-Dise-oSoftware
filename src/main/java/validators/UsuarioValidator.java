/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

/**
 *
 * @author sofia
 */
public class UsuarioValidator {

    public static boolean validateContrasenia(String contrasenia) {
        return contrasenia != null && !contrasenia.trim().isEmpty();
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

}
