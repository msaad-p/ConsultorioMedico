package org.example;

import java.util.Scanner;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        SistemaAgendamiento sistema = new SistemaAgendamiento();
        System.out.println("=== Bienvenide al sistema de agendamiento de citas ===\n");
        int opcion = 0;

        while (opcion!=11) {
            try {
                System.out.println("""
                        ---
                        ===MENÚ===
                           Escriba el número de la opción del menú a la que quiere acceder:
                               1. Agregar un nuevo usuario.
                               2. Agregar un nuevo médico.
                               3. Agregar una nueva cita.
                               4. Buscar un usuario existente.
                               5. Buscar un médico existente.
                               6. Buscar una cita existente.
                               7. Eliminar una cita existente.
                               8. Mostrar todas las citas.
                               9. Mostrar citas de un paciente.
                               10. Mostrar citas de un médico.
                               11. Salir del programa.
                        ---
                        """);
                opcion = in.nextInt();
                in.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --agregar nuevo usuario--");
                        System.out.println("*Ingrese los datos del usuario:");
                        System.out.print("Nombre: ");
                        String nombreUsuario = in.nextLine();
                        System.out.print("Número de Identificación: ");
                        String numIdUsuario = in.nextLine();
                        System.out.print("Teléfono: ");
                        String telUsuario = in.nextLine();
                        System.out.print("Correo Electrónico: ");
                        String emailUsuario = in.nextLine();

                        Usuario nuevoUsuario = new Usuario(nombreUsuario, numIdUsuario, telUsuario, emailUsuario, new Cita[25]);
                        if (sistema.agregarUsuario(nuevoUsuario)) {
                            System.out.println("Usuario " + nuevoUsuario.getNombre() + " agregado con éxito. ID: " + nuevoUsuario.getId());
                        } else {
                            System.out.println("Error: No se pudo agregar el usuario. Puede que ya exista o el sistema esté lleno.");
                        }
                        System.out.println("---\n");
                        break;
                    case 2:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --agregar nuevo médico--");
                        System.out.println("*Ingrese los datos del médico:");
                        System.out.print("Nombre: ");
                        String nombreMedico = in.nextLine();
                        System.out.print("Número de Identificación: ");
                        String numIdMedico = in.nextLine();
                        System.out.print("Teléfono: ");
                        String telMedico = in.nextLine();
                        System.out.print("Correo Electrónico: ");
                        String emailMedico = in.nextLine();

                        Medico nuevoMedico = new Medico(nombreMedico, numIdMedico, telMedico, emailMedico, new Cita[25]);
                        if (sistema.agregarMedico(nuevoMedico)) {
                            System.out.println("Médico " + nuevoMedico.getNombre() + " agregado con éxito. ID: " + nuevoMedico.getId());
                        } else {
                            System.out.println("Error: No se pudo agregar el médico. Puede que ya exista o el sistema esté lleno.");
                        }
                        System.out.println("---\n");
                        break;
                    case 3:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --agregar nueva cita--");
                        System.out.println("*Ingrese los datos de la cita:");

                        System.out.print("ID del paciente: ");
                        String idPacienteCita = in.nextLine();
                        int posPaciente = -1;
                        for (int i = 0; i < sistema.getCantidadUsuarios(); i++) {
                            if (sistema.getUsuarios()[i].getId().equals(idPacienteCita)) {
                                posPaciente = i;
                                break;
                            }
                        }
                        if (posPaciente == -1) {
                            System.out.println("Error: Paciente con ID " + idPacienteCita + " no encontrado.");
                            System.out.println("---\n");
                            break;
                        }
                        Usuario pacienteCita = sistema.getUsuarios()[posPaciente];

                        System.out.print("ID del médico: ");
                        String idMedicoCita = in.nextLine();
                        int posMedico = -1;
                        for (int i = 0; i < sistema.getCantidadMedicos(); i++) {
                            if (sistema.getMedicos()[i].getId().equals(idMedicoCita)) {
                                posMedico = i;
                                break;
                            }
                        }
                        if (posMedico == -1) {
                            System.out.println("Error: Médico con ID " + idMedicoCita + " no encontrado.");
                            System.out.println("---\n");
                            break;
                        }
                        Medico medicoCita = sistema.getMedicos()[posMedico];

                        Date fechaCita = null;
                        Time horaCita = null;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                        System.out.print("Fecha de la cita (dd/MM/yyyy): ");
                        String fechaStr = in.nextLine();
                        try {
                            fechaCita = dateFormat.parse(fechaStr);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha inválido. Use dd/MM/yyyy.");
                            System.out.println("---\n");
                            break;
                        }

                        System.out.print("Hora de la cita (HH:mm): ");
                        String horaStr = in.nextLine();
                        try {
                            Date parsedTime = timeFormat.parse(horaStr);
                            horaCita = new Time(parsedTime.getTime());
                        } catch (ParseException e) {
                            System.out.println("Formato de hora inválido. Use HH:mm.");
                            System.out.println("---\n");
                            break;
                        }

                        Cita nuevaCita = new Cita(fechaCita, horaCita, pacienteCita, medicoCita);
                        if (sistema.agregarCita(nuevaCita)) {
                            System.out.println("Cita agendada con éxito. ID: " + nuevaCita.getId());
                        } else {
                            System.out.println("Error: No se pudo agendar la cita. Verifique si el médico está disponible o si el paciente/médico tienen espacio para más citas.");
                        }
                        System.out.println("---\n");
                        break;
                    case 4:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --buscar un usuario existente--");
                        System.out.print("Ingrese el ID del usuario a buscar: ");
                        String idBuscarUsuario = in.nextLine();
                        int posUsuarioEncontrado = -1;
                        for (int i = 0; i < sistema.getCantidadUsuarios(); i++) {
                            if (sistema.getUsuarios()[i].getId().equals(idBuscarUsuario)) {
                                posUsuarioEncontrado = i;
                                break;
                            }
                        }
                        if (posUsuarioEncontrado != -1) {
                            Usuario u = sistema.getUsuarios()[posUsuarioEncontrado];
                            System.out.println("Usuario encontrado:");
                            System.out.println("  ID: " + u.getId());
                            System.out.println("  Nombre: " + u.getNombre());
                            System.out.println("  Número de Identificación: " + u.getNumeroIdentificacion());
                            System.out.println("  Teléfono: " + u.getTelefono());
                            System.out.println("  Correo Electrónico: " + u.getCorreoElectronico());
                            if (u.getCantidadCitasUsuario() > 0) {
                                System.out.println("  Citas del usuario:");
                                for (int i = 0; i < u.getCantidadCitasUsuario(); i++) {
                                    System.out.println("    - " + u.getCitas()[i].getId() + " - " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(u.getCitas()[i].getFecha()) + " con Dr(a). " + u.getCitas()[i].getMedico().getNombre());
                                }
                            } else {
                                System.out.println("  El usuario no tiene citas agendadas.");
                            }
                        } else {
                            System.out.println("Usuario con ID " + idBuscarUsuario + " no encontrado.");
                        }
                        System.out.println("---\n");
                        break;
                    case 5:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --buscar un médico existente--");
                        System.out.print("Ingrese el ID del médico a buscar: ");
                        String idBuscarMedico = in.nextLine();
                        int posMedicoEncontrado = -1;
                        for (int i = 0; i < sistema.getCantidadMedicos(); i++) {
                            if (sistema.getMedicos()[i].getId().equals(idBuscarMedico)) {
                                posMedicoEncontrado = i;
                                break;
                            }
                        }
                        if (posMedicoEncontrado != -1) {
                            Medico m = sistema.getMedicos()[posMedicoEncontrado];
                            System.out.println("Médico encontrado:");
                            System.out.println("  ID: " + m.getId());
                            System.out.println("  Nombre: " + m.getNombre());
                            System.out.println("  Número de Identificación: " + m.getNumeroIdentificacion());
                            System.out.println("  Teléfono: " + m.getTelefono());
                            System.out.println("  Correo Electrónico: " + m.getCorreoElectronico());
                            if (m.getCantidadCitasMedico() > 0) {
                                System.out.println("  Citas del médico:");
                                for (int i = 0; i < m.getCantidadCitasMedico(); i++) {
                                    System.out.println("    - " + m.getCitas()[i].getId() + " - " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(m.getCitas()[i].getFecha()) + " con paciente " + m.getCitas()[i].getPaciente().getNombre());
                                }
                            } else {
                                System.out.println("  El médico no tiene citas agendadas.");
                            }
                        } else {
                            System.out.println("Médico con ID " + idBuscarMedico + " no encontrado.");
                        }
                        System.out.println("---\n");
                        break;
                    case 6:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --buscar una cita existente--");
                        System.out.print("Ingrese el ID de la cita a buscar: ");
                        String idBuscarCita = in.nextLine();
                        int posCitaEncontrada = -1;
                        for (int i = 0; i < sistema.getCantidadCitas(); i++) {
                            if (sistema.getCitas()[i].getId().equals(idBuscarCita)) {
                                posCitaEncontrada = i;
                                break;
                            }
                        }
                        if (posCitaEncontrada != -1) {
                            Cita c = sistema.getCitas()[posCitaEncontrada];
                            System.out.println("Cita encontrada:");
                            System.out.println(c.toString());
                        } else {
                            System.out.println("Cita con ID " + idBuscarCita + " no encontrada.");
                        }
                        System.out.println("---\n");
                        break;
                    case 7:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --eliminar una cita existente--");
                        System.out.print("Ingrese el ID de la cita que desea eliminar: ");
                        String idEliminarCita = in.nextLine();
                        if (sistema.eliminarCita(idEliminarCita)) {
                            System.out.println("Cita con ID " + idEliminarCita + " eliminada con éxito.");
                        } else {
                            System.out.println("Error: No se pudo eliminar la cita. Puede que no exista una cita con ese ID.");
                        }
                        System.out.println("---\n");
                        break;
                    case 8:
                        System.out.println("\n---");
                        System.out.println("=== Citas Globales ===");
                        if (sistema.getCantidadCitas() == 0) {
                            System.out.println("No hay citas agendadas en el sistema.");
                        } else {
                            for (int i = 0; i < sistema.getCantidadCitas(); i++) {
                                String citaprint = sistema.getCitas()[i].toString();
                                System.out.println("Cita "+(i+1)+": \n"+citaprint);
                            }
                        }
                        System.out.println("======================");
                        System.out.println("---\n");
                        break;
                    case 9:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --mostrar citas de un paciente--");
                        System.out.print("Ingrese el ID del paciente: ");
                        String idPacienteMostrarCitas = in.nextLine();
                        int posPacienteMostrar = -1;
                        for (int i = 0; i < sistema.getCantidadUsuarios(); i++) {
                            if (sistema.getUsuarios()[i].getId().equals(idPacienteMostrarCitas)) {
                                posPacienteMostrar = i;
                                break;
                            }
                        }
                        if (posPacienteMostrar != -1) {
                            Usuario paciente = sistema.getUsuarios()[posPacienteMostrar];
                            if (paciente.getCantidadCitasUsuario() > 0) {
                                System.out.println("\n=== Citas del paciente " + paciente.getNombre() + " ===");
                                for (int i = 0; i < paciente.getCantidadCitasUsuario(); i++) {
                                    System.out.println("Cita " + (i+1) + ": \n" + paciente.getCitas()[i].toString());
                                }
                                System.out.println("======================");
                            } else {
                                System.out.println("El paciente " + paciente.getNombre() + " no tiene citas agendadas.");
                            }
                        } else {
                            System.out.println("Paciente con ID " + idPacienteMostrarCitas + " no encontrado.");
                        }
                        System.out.println("---\n");
                        break;
                    case 10:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --mostrar citas de un médico--");
                        System.out.print("Ingrese el ID del médico: ");
                        String idMedicoMostrarCitas = in.nextLine();
                        int posMedicoMostrar = -1;
                        for (int i = 0; i < sistema.getCantidadMedicos(); i++) {
                            if (sistema.getMedicos()[i].getId().equals(idMedicoMostrarCitas)) {
                                posMedicoMostrar = i;
                                break;
                            }
                        }
                        if (posMedicoMostrar != -1) {
                            Medico medico = sistema.getMedicos()[posMedicoMostrar];
                            if (medico.getCantidadCitasMedico() > 0) {
                                System.out.println("\n=== Citas del médico " + medico.getNombre() + " ===");
                                for (int i = 0; i < medico.getCantidadCitasMedico(); i++) {
                                    System.out.println("Cita " + (i+1) + ": \n" + medico.getCitas()[i].toString());
                                }
                                System.out.println("======================");
                            } else {
                                System.out.println("El médico " + medico.getNombre() + " no tiene citas agendadas.");
                            }
                        } else {
                            System.out.println("Médico con ID " + idMedicoMostrarCitas + " no encontrado.");
                        }
                        System.out.println("---\n");
                        break;
                    case 11:
                        System.out.println("Gracias por usar el programa. Saliendo ahora.");
                        break;
                    default:
                        System.out.println("La opción escogida no es válida, intente de nuevo");
                }

            } catch (Exception e) {
                System.out.println("Error: Ha ingresado un valor inválido. Por favor, intente de nuevo con un número del menú.");
                in.nextLine();
            }
        }
        in.close();
    }
}