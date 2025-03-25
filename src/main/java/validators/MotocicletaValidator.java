/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

/**
 *
 * @author sofia
 */
public class MotocicletaValidator {

    public static boolean validatePlaca(String placa) {
        return placa != null && !placa.trim().isEmpty();
    }

    public static boolean validateMarca(String marca) {
        return marca != null && !marca.trim().isEmpty();
    }

    public static boolean validateColor(String color) {
        return color != null && !color.trim().isEmpty();
    }
    
    public static boolean validateCilindraje(int cilindraje){
        return cilindraje>0;
    }
    
    public static boolean validatePrecio(float precio) {
        return precio > 0.0;
    }

}
