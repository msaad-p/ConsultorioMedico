package org.example;

import java.util.Scanner;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        SistemaAgendamiento sistema = new SistemaAgendamiento();

        Usuario usuario1 = new Usuario("Carlos Reza", 10854254785L, 3001112233L, "carlos.reza@gmail.com");
        Usuario usuario2 = new Usuario("David Blásquez", 10921345678L, 3104445566L, "david.blasquez@gmail.com");
        Usuario usuario3 = new Usuario("Marco Paluszny", 10769876543L, 3207778899L, "marco.paluszny@gmail.com");
        Usuario usuario4 = new Usuario("Leopoldo Múnera", 10501234567L, 3012223344L, "leopoldo.munera@gmail.com");
        Usuario usuario5 = new Usuario("Jhon Fredy Ruiz", 10112233445L, 3159990011L, "jhon.ruiz@gmail.com");

        sistema.agregarUsuario(usuario1);
        sistema.agregarUsuario(usuario2);
        sistema.agregarUsuario(usuario3);
        sistema.agregarUsuario(usuario4);
        sistema.agregarUsuario(usuario5);

        Medico medico1 = new Medico("Dr. Carlos Vélez", 11001122334L, 3009876543L, "carlos.velez@gmail.com");
        Medico medico2 = new Medico("Dra. Juan Diego Caicedo", 11112233445L, 3108765432L, "juan.caicedo@gmail.com");
        Medico medico3 = new Medico("Dr. Daniele Sepe", 11223344556L, 3207654321L, "daniele.sepe@gmail.com");
        Medico medico4 = new Medico("Dra. Bibiana López", 11334455667L, 3016543210L, "bibiana.lopez@gmail.com");
        Medico medico5 = new Medico("Dr. Daniel Cabarcas", 11445566778L, 3155432109L, "daniel.cabarcas@gmail.com");

        sistema.agregarMedico(medico1);
        sistema.agregarMedico(medico2);
        sistema.agregarMedico(medico3);
        sistema.agregarMedico(medico4);
        sistema.agregarMedico(medico5);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        Date fechaCitaM1_1 = dateFormat.parse("15/07/2025");
        Time horaCitaM1_1 = new Time(timeFormat.parse("09:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM1_1, horaCitaM1_1, usuario1, medico1));

        Date fechaCitaM1_2 = dateFormat.parse("15/07/2025");
        Time horaCitaM1_2 = new Time(timeFormat.parse("10:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM1_2, horaCitaM1_2, usuario2, medico1));

        Date fechaCitaM1_3 = dateFormat.parse("15/07/2025");
        Time horaCitaM1_3 = new Time(timeFormat.parse("11:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM1_3, horaCitaM1_3, usuario3, medico1));

        Date fechaCitaM2_1 = dateFormat.parse("15/07/2025");
        Time horaCitaM2_1 = new Time(timeFormat.parse("13:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM2_1, horaCitaM2_1, usuario4, medico2));

        Date fechaCitaM2_2 = dateFormat.parse("15/07/2025");
        Time horaCitaM2_2 = new Time(timeFormat.parse("14:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM2_2, horaCitaM2_2, usuario5, medico2));

        Date fechaCitaM2_3 = dateFormat.parse("15/07/2025");
        Time horaCitaM2_3 = new Time(timeFormat.parse("15:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM2_3, horaCitaM2_3, usuario1, medico2));

        Date fechaCitaM3_1 = dateFormat.parse("16/07/2025");
        Time horaCitaM3_1 = new Time(timeFormat.parse("09:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM3_1, horaCitaM3_1, usuario2, medico3));

        Date fechaCitaM3_2 = dateFormat.parse("16/07/2025");
        Time horaCitaM3_2 = new Time(timeFormat.parse("10:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM3_2, horaCitaM3_2, usuario3, medico3));

        Date fechaCitaM3_3 = dateFormat.parse("16/07/2025");
        Time horaCitaM3_3 = new Time(timeFormat.parse("11:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM3_3, horaCitaM3_3, usuario4, medico3));

        Date fechaCitaM4_1 = dateFormat.parse("16/07/2025");
        Time horaCitaM4_1 = new Time(timeFormat.parse("14:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM4_1, horaCitaM4_1, usuario5, medico4));

        Date fechaCitaM4_2 = dateFormat.parse("16/07/2025");
        Time horaCitaM4_2 = new Time(timeFormat.parse("15:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM4_2, horaCitaM4_2, usuario1, medico4));

        Date fechaCitaM4_3 = dateFormat.parse("16/07/2025");
        Time horaCitaM4_3 = new Time(timeFormat.parse("16:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM4_3, horaCitaM4_3, usuario2, medico4));

        Date fechaCitaM5_1 = dateFormat.parse("17/07/2025");
        Time horaCitaM5_1 = new Time(timeFormat.parse("09:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM5_1, horaCitaM5_1, usuario3, medico5));

        Date fechaCitaM5_2 = dateFormat.parse("17/07/2025");
        Time horaCitaM5_2 = new Time(timeFormat.parse("10:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM5_2, horaCitaM5_2, usuario4, medico5));

        Date fechaCitaM5_3 = dateFormat.parse("17/07/2025");
        Time horaCitaM5_3 = new Time(timeFormat.parse("11:00").getTime());
        sistema.agregarCita(new Cita(fechaCitaM5_3, horaCitaM5_3, usuario5, medico5));

        System.out.println("=== Bienvenide al sistema de agendamiento de citas ===\n");
        int opcion = 0;

        while (opcion!=13) {
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
                               11. Mostrar todos los usuarios.
                               12. Mostrar todos los médicos.
                               13. Salir del programa.
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
                        long numIdUsuario;
                        while (true) {
                            System.out.print("Número de Identificación: ");
                            try {
                                numIdUsuario = Long.parseLong(in.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número de identificación válido.");
                            }
                        }
                        long telUsuario;
                        while (true) {
                            System.out.print("Teléfono: ");
                            try {
                                telUsuario = Long.parseLong(in.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número de teléfono válido.");
                            }
                        }
                        System.out.print("Correo Electrónico: ");
                        String emailUsuario = in.nextLine();

                        Usuario nuevoUsuario = new Usuario(nombreUsuario, numIdUsuario, telUsuario, emailUsuario);
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
                        long numIdMedico;
                        while (true) {
                            System.out.print("Número de Identificación: ");
                            try {
                                numIdMedico = Long.parseLong(in.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número de identificación válido.");
                            }
                        }
                        long telMedico;
                        while (true) {
                            System.out.print("Teléfono: ");
                            try {
                                telMedico = Long.parseLong(in.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Por favor, ingrese un número de teléfono válido.");
                            }
                        }
                        System.out.print("Correo Electrónico: ");
                        String emailMedico = in.nextLine();

                        Medico nuevoMedico = new Medico(nombreMedico, numIdMedico, telMedico, emailMedico);
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
                        int posPaciente = sistema.buscarUsuario(idPacienteCita);

                        if (posPaciente == -1) {
                            System.out.println("Error: Paciente con ID " + idPacienteCita + " no encontrado.");
                            System.out.println("---\n");
                            break;
                        }
                        Usuario pacienteCita = sistema.getUsuarios()[posPaciente];

                        System.out.print("ID del médico: ");
                        String idMedicoCita = in.nextLine();
                        int posMedico = sistema.buscarMedico(idMedicoCita);

                        if (posMedico == -1) {
                            System.out.println("Error: Médico con ID " + idMedicoCita + " no encontrado.");
                            System.out.println("---\n");
                            break;
                        }
                        Medico medicoCita = sistema.getMedicos()[posMedico];

                        Date fechaCita = null;
                        Time horaCita = null;;

                        System.out.print("Fecha de la cita (dd/mm/yyyy): ");
                        String fechaStr = in.nextLine();
                        try {
                            fechaCita = dateFormat.parse(fechaStr);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha inválido. Use dd/mm/yyyy.");
                            System.out.println("---\n");
                            break;
                        }

                        System.out.print("Hora de la cita (hh:mm): ");
                        String horaStr = in.nextLine();
                        try {
                            Date parsedTime = timeFormat.parse(horaStr);
                            horaCita = new Time(parsedTime.getTime());
                        } catch (ParseException e) {
                            System.out.println("Formato de hora inválido. Use hh:mm.");
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
                        int posUsuarioEncontrado = sistema.buscarUsuario(idBuscarUsuario);

                        if (posUsuarioEncontrado != -1) {
                            Usuario u = sistema.getUsuarios()[posUsuarioEncontrado];
                            System.out.println("Usuario encontrado:");
                            System.out.println(u.toString());
                            if (u.getCantidadCitasUsuario() > 0) {
                                System.out.println("  Citas del usuario:");
                                for (int i = 0; i < u.getCantidadCitasUsuario(); i++) {
                                    System.out.println("    - ID Cita: " + u.getCitas()[i].getId() +
                                            " | Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(u.getCitas()[i].getFecha()) +
                                            " | Hora: " + new SimpleDateFormat("HH:mm").format(u.getCitas()[i].getHora()) +
                                            " | Médico: " + u.getCitas()[i].getMedico().getNombre());
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
                        int posMedicoEncontrado = sistema.buscarMedico(idBuscarMedico);

                        if (posMedicoEncontrado != -1) {
                            Medico m = sistema.getMedicos()[posMedicoEncontrado];
                            System.out.println("Médico encontrado:");
                            System.out.println(m.toString());
                            if (m.getCantidadCitasMedico() > 0) {
                                System.out.println("  Citas del médico:");
                                for (int i = 0; i < m.getCantidadCitasMedico(); i++) {
                                    System.out.println("    - ID Cita: " + m.getCitas()[i].getId() +
                                            " | Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(m.getCitas()[i].getFecha()) +
                                            " | Hora: " + new SimpleDateFormat("HH:mm").format(m.getCitas()[i].getHora()) +
                                            " | Paciente: " + m.getCitas()[i].getPaciente().getNombre());
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
                        int posCitaEncontrada = sistema.buscarCita(idBuscarCita);

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
                        sistema.mostrarCitasGlobal();
                        break;
                    case 9:
                        System.out.println("\n---");
                        System.out.println("Ha ingresado a la opción de --mostrar citas de un paciente--");
                        System.out.print("Ingrese el ID del paciente: ");
                        String idPacienteMostrarCitas = in.nextLine();
                        int posPacienteMostrar = sistema.buscarUsuario(idPacienteMostrarCitas);

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
                        int posMedicoMostrar = sistema.buscarMedico(idMedicoMostrarCitas);

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
                        sistema.mostrarUsuarios();
                        break;
                    case 12:
                        sistema.mostrarMedicos();
                        break;
                    case 13:
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