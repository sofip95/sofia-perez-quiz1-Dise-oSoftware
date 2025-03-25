/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.quiz;

import exceptions.InvalidMotocicletaDataException;
import exceptions.InvalidUsuarioDataException;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.util.Scanner;
import services.MotocicletaService;
import services.UsuarioService;

/**
 *
 * @author sofia
 */
public class Quiz {

    public static void main(String[] args) throws SQLException, InvalidUsuarioDataException, InvalidMotocicletaDataException {
        UsuarioService usuarioService = new UsuarioService();
        MotocicletaService motocicletaService = new MotocicletaService();
        System.out.print("Introduce nombre de usuario: ");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Introduce nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Introduce contraseña: ");
                String password = scanner.nextLine();

                boolean success = usuarioService.createUser(username, password);
                if (success) {
                    System.out.println("Usuario registrado con éxito.");
                } else {
                    System.out.println("Error al registrar el usuario. Es posible que el nombre ya esté registrado.");
                }

            } else if (choice == 2) {
                System.out.print("Introduce nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Introduce contraseña: ");
                String password = scanner.nextLine();

                boolean success = usuarioService.login(username, password);
                if (success) {
                    System.out.println("Inicio de sesión exitoso.");
                    System.out.println("\n1. Registrar motocicleta");
                    System.out.println("2. Editar motocicleta");
                    System.out.println("3. Eliminar motocicleta");
                    System.out.println("4. Volver al menu principal");
                    System.out.print("Elige una opción: ");
                    int op = scanner.nextInt();
                    scanner.nextLine();
                    if (op == 1) {
                        System.out.print("Introduce la placa de la motocicleta: ");
                        String id = scanner.nextLine();
                        System.out.print("Introduce la marca de la motocicleta: ");
                        String marca = scanner.nextLine();
                        System.out.print("Introduce el cilindraje: ");
                        int cilindraje = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el precio: ");
                        float precio = Float.parseFloat(scanner.nextLine());
                        System.out.print("Introduce el color de la motocicleta: ");
                        String color = scanner.nextLine();
                        boolean exito = motocicletaService.createMotocicleta(id, marca, cilindraje, precio, color);
                        if (exito) {
                            System.out.println("Motocicleta registrada con éxito.");
                            
                        } else {
                            System.out.println("Error al registrar la motocicleta. Es posible que la placa ya esté registrada.");
                        }
                    } else if (op == 2) {
                        System.out.print("Introduce la placa de la motocicleta: ");
                        String id = scanner.nextLine();
                        System.out.print("Introduce la marca de la motocicleta: ");
                        String marca = scanner.nextLine();
                        System.out.print("Introduce el cilindraje: ");
                        int cilindraje = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el precio: ");
                        float precio = Float.parseFloat(scanner.nextLine());
                        System.out.print("Introduce el color de la motocicleta: ");
                        String color = scanner.nextLine();
                        boolean exito = motocicletaService.updateMotocicleta(id, marca, cilindraje, precio, color);
                        if (exito) {
                            System.out.println("Motocicleta editada con éxito.");
                        } else {
                            System.out.println("Error al editar la motocicleta.");
                        }
                    } else if (op == 3) {
                        System.out.print("Introduce la placa de la motocicleta: ");
                        String id = scanner.nextLine();
                        boolean exito = motocicletaService.deleteMotocicleta(id);
                        if(exito){
                            System.out.println("Motocicleta eliminada con éxito");
                        }else{
                            System.out.println("Error al eliminar la motocicleta");
                        }
                    } else if(op == 4){
                    
                    }
                } else {
                    System.out.println("Usuario o contraseña incorrectos.");
                }

            } else if (choice == 3) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}
