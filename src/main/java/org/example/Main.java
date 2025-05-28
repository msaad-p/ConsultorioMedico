package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("=== Bienvenide al sistema de agendamiento de citas ===\n");
        int opcion = 0;
        while (opcion!=8){
            System.out.println("""
                    ===MENÚ===
                       Escriba el número de la opción del menú a la que quiere acceder:
                           1. Agregar un nuevo usuario.
                           2. Agregar un nuevo médico.
                           3. Agregar una nueva cita.
                           4. Buscar un usuario existente.
                           5. Buscar un médico existente.
                           6. Buscar una cita existente.
                           7. Eliminar una cita existente.
                           8. Salir del programa
                    """);
            opcion = in.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ha ingresado a la opción de --agregar nuevo usuario--");
                    break;
                case 2:
                    System.out.println("Ha ingresado a la opción de --agregar nuevo médico--");
                    break;
                case 3:
                    System.out.println("Ha ingresado a la opción de --agregar nueva cita--");
                    break;
                case 4:
                    System.out.println("Ha ingresado a la opción de --buscar un usuario existente--");
                    break;
                case 5:
                    System.out.println("Ha ingresado a la opción de --buscar un médico existente--");
                    break;
                case 6:
                    System.out.println("Ha ingresado a la opción de --buscar una cita existente--");
                    break;
                case 7:
                    System.out.println("Ha ingresado a la opción de --eliminar una cita existente--");
                    break;
                case 8:
                    System.out.println("Gracias por usar el programa. Saliendo ahora.");
                    break;
                default:
                    System.out.println("La opción escogida no es válida, intente de nuevo");
            }
        }
    }
}