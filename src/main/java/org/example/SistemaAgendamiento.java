package org.example;

import java.util.Objects;

public class SistemaAgendamiento {
    private Usuario[] usuarios = new Usuario[25];
    private Medico[] medicos = new Medico[25];
    private Cita[] citas = new Cita[50];
    private int cantidadUsuarios = 0;
    private int cantidadMedicos = 0;
    private int cantidadCitas = 0;

    public SistemaAgendamiento() {
    }

    public int buscarUsuario(String idBuscar) {
        /*
         * Retorna la posición de un usuario del arreglo de usuarios según su ID.
         *
         * Recorre el arreglo usuarios hasta encontrar igualdad de IDs.
         *
         * Input: idBuscar El ID del Usuario que se desea buscar.
         * Output: La posición del usuario si fue encontrado; -1 si no se encontró ningún usuario con ese ID.
         */
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (Objects.equals(usuarios[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    public int buscarMedico(String idBuscar) {
        /*
         * Retorna la posición de un médico del arreglo de médicos según su ID.
         *
         * Recorre el arreglo médicos hasta encontrar igualdad de IDs.
         *
         * Input: idBuscar El ID del médico que se desea buscar.
         * Output: La posición del médico si fue encontrado; -1 si no se encontró ningún medico con ese ID.
         */
        for (int i = 0; i < cantidadMedicos; i++) {
            if (Objects.equals(medicos[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    public int buscarCita(String idBuscar) {
        /*
         * Retorna la posición de una cita del arreglo de citas según su ID.
         *
         * Recorre el arreglo citas hasta encontrar igualdad de IDs.
         *
         * Input: idBuscar El ID de la cita que se desea buscar.
         * Output: La posición de la cita si fue encontrada; -1 si no se encontró ninguna cita con ese ID.
         */
        for (int i = 0; i < cantidadCitas; i++) {
            if (Objects.equals(citas[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    public boolean eliminarCita(String idBuscar) {
        /*
         * Elimina una cita del arreglo de citas según su ID,
         * y también la elimina de los arreglos de citas del paciente y del médico.
         *
         * Busca la posición de la cita con el ID especificado. Si se encuentra:
         * - Se elimina de la lista principal de citas.
         * - Se elimina de la lista de citas del paciente asociado.
         * - Se elimina de la la lista de citas del médico asociado.
         * - Las citas posteriores se desplazan a la izquierda para llenar el espacio.
         *
         * Input: idBuscar El ID de la cita que se desea eliminar.
         * Output: true si la cita fue encontrada y eliminada; false si no se encontró ninguna cita con ese ID.
         */
        int posicionEliminarCitaPrincipal = buscarCita(idBuscar);
        if (posicionEliminarCitaPrincipal == -1) {
            return false; /* La cita no se encontró */
        }

        Cita citaAEliminar = citas[posicionEliminarCitaPrincipal];

        /* Eliminar la cita del paciente */
        Usuario paciente = usuarios[buscarUsuario(citaAEliminar.getPaciente().getId())];
        int posicionCitaPaciente = -1;
        for (int i = 0; i < paciente.getCantidadCitasUsuario(); i++) {
            if (Objects.equals(paciente.getCitas()[i].getId(), idBuscar)) {
                posicionCitaPaciente = i;
                break;
            }
        }

        if (posicionCitaPaciente != -1) {
            for (int i = posicionCitaPaciente; i < paciente.getCantidadCitasUsuario() - 1; i++) {
                paciente.getCitas()[i] = paciente.getCitas()[i + 1];
            }
            paciente.getCitas()[paciente.getCantidadCitasUsuario() - 1] = null; /* Limpiar la última posición */
            paciente.setCantidadCitasUsuario(paciente.getCantidadCitasUsuario() - 1); /* Decrementar la cantidad de citas del paciente */
        }

        /* Eliminar la cita del médico */
        Medico medico = medicos[buscarMedico(citaAEliminar.getMedico().getId())];
        int posicionCitaMedico = -1;
        for (int i = 0; i < medico.getCantidadCitasMedico(); i++) {
            if (Objects.equals(medico.getCitas()[i].getId(), idBuscar)) {
                posicionCitaMedico = i;
                break;
            }
        }

        if (posicionCitaMedico != -1) {
            for (int i = posicionCitaMedico; i < medico.getCantidadCitasMedico() - 1; i++) {
                medico.getCitas()[i] = medico.getCitas()[i + 1];
            }
            medico.getCitas()[medico.getCantidadCitasMedico() - 1] = null; /* Limpiar la última posición */
            medico.setCantidadCitasMedico(medico.getCantidadCitasMedico() - 1); /* Decrementar la cantidad de citas del médico */
        }

        /* Eliminar la cita del arreglo principal de citas */
        for (int i = posicionEliminarCitaPrincipal; i < (cantidadCitas - 1); i++) {
            citas[i] = citas[i + 1];
        }
        citas[cantidadCitas - 1] = null; /* Limpiar la última posición */
        cantidadCitas--; /* Decrementar el contador global de citas */

        return true;
    }

    public boolean agregarUsuario(Usuario usuario) {
        /*
         * Agrega un usuario al arreglo de usuario dado un usuario.
         *
         * Busca el usuario con el ID.
         * Si se encuentra:
         * -Ya existe este usuario
         * Si el largo del arreglo permite ingresar un usuario:
         * Agrega al usuario a ese índice y aumenta la cantidad de usuarios
         * Si el largo del arreglo no lo permite:
         * Hay máximo de usuarios
         *
         * Input: Instancia del usuario.
         * Output: Si se encuentra en el array retorna false, si hay espacio retorna true y sino retorna false.
         */
        if(buscarUsuario(usuario.getId())!=-1){
            return false; /*Ya existe el usuario */
        }
        if(cantidadUsuarios<usuarios.length){
            usuarios[cantidadUsuarios]=usuario; /*Se encontró espacio para nuevo usuario */
            cantidadUsuarios++;
            return true;
        }
        return false; /*No hay espacio para más usuarios */
    }

    public boolean agregarMedico(Medico medico) {
        /*
         * Agrega un médico al arreglo de médicos dado un médico.
         * Busca el médico con el ID.
         * Si se encuentra:
         * -Ya existe este médico
         * Si el largo del arreglo permite ingresar un médico:
         * Agrega al médico a ese índice y aumenta la cantidad de médicos
         * Si el largo del arreglo no lo permite:
         * Hay máximo de médicos
         * Input: Instancia del médico.
         * Output: Si se encuentra en el array retorna false, si hay espacio retorna true y sino retorna false.
         */
        if(buscarMedico(medico.getId())!=-1){
            return false; /*Ya existe el médico */
        }
        if(cantidadMedicos<medicos.length){
            medicos[cantidadMedicos]=medico; /*Se encontró espacio para nuevo médico */
            cantidadMedicos++;
            return true;
        }
        return false; /*No hay espacio para más médicos */
    }

    public boolean agregarCita(Cita cita) {
        /*
         * Agrega una cita al arreglo de citas dado una cita.
         * Busca la cita con el ID.
         * Si se encuentra:
         * -Ya existe esta cita
         * Se hacen las validaciones de existencia del médico y el usuario.
         * Si alguno no existe en en sistema, retorna false.
         * Se verifica que en sus arrays quepan citas.
         * Si a alguno no le cabe más citas, retorna false.
         * Si el largo del arreglo de citas y de médico y usuario permite ingresar una cita:
         * Agrega la cita a ese índice y aumenta la cantidad de citas
         * Si el largo del arreglo no lo permite:
         * Hay máximo de citas
         * Input: Instancia de la cita.
         * Output: Si se encuentra en el array retorna false, si no cumple las validaciones retorna false, si hay espacio retorna true y sino retorna false.
         */
        if(buscarCita(cita.getId()) != -1){
            return false; /*Ya existe la cita */
        }

        /* Buscar al paciente y al médico */
        int indicePaciente = buscarUsuario(cita.getPaciente().getId());
        int indiceMedico = buscarMedico(cita.getMedico().getId());

        /* Validar que el paciente y el médico existan en el sistema */
        if (indicePaciente == -1 || indiceMedico == -1) {
            return false; /* El paciente o el médico no se encontraron en el sistema */
        }

        Usuario paciente = usuarios[indicePaciente];
        Medico medico = medicos[indiceMedico];

        /* Validar espacio en el arreglo de citas del usuario */
        if (paciente.getCantidadCitasUsuario() >= paciente.getCitas().length) {
            return false; /* El paciente no tiene espacio para más citas */
        }

        /* Validar espacio en el arreglo de citas del médico */
        if (medico.getCantidadCitasMedico() >= medico.getCitas().length) {
            return false; /* El médico no tiene espacio para más citas */
        }

        /* Si 'verificarDisponibilidad' retorna 'false', significa que el horario no está disponible. */
        if (!medico.verificarDisponibilidad(cita.getFecha(), cita.getHora())) {
            return false; /* El horario solicitado no está disponible para el médico. */
        }

        if(cantidadCitas < citas.length){
            citas[cantidadCitas] = cita; /*Se encontró espacio para nueva cita */
            cantidadCitas++;

            /* Agregar la cita al paciente */
            paciente.getCitas()[paciente.getCantidadCitasUsuario()] = cita;
            paciente.setCantidadCitasUsuario(paciente.getCantidadCitasUsuario() + 1);

            /* Agregar la cita al médico */
            medico.getCitas()[medico.getCantidadCitasMedico()] = cita;
            medico.setCantidadCitasMedico(medico.getCantidadCitasMedico() + 1);

            return true;
        }
        return false; /*No hay espacio para más citas */
    }

    public void  mostrarCitasGlobal() {
        /*
         * Mostrar todas la citas de forma global.
         *
         * Recorre todas las citas y los imprime.
         * Input: Nada.
         * Output: Muestra las citas.
         */
        System.out.println("\n=== Citas Global ===");
        if (cantidadCitas == 0) {
            System.out.println("No hay citas registradas en el sistema.");
        } else {
            for (int i = 0; i < cantidadCitas; i++) {
                String citaprint = citas[i].toString();
                System.out.println("Cita " + (i + 1) + ": \n" + citaprint);
            }
        }
        System.out.println("======================");
    }

    public void mostrarUsuarios() {
        System.out.println("\n=== Lista de Usuarios ===");
        if (cantidadUsuarios == 0) {
            System.out.println("No hay usuarios registrados en el sistema.");
        } else {
            for (int i = 0; i < cantidadUsuarios; i++) {
                System.out.println("Usuario " + (i + 1) + ": \n" + usuarios[i].toString());
            }
        }
        System.out.println("=========================\n");
    }

    public void mostrarMedicos() {
        System.out.println("\n=== Lista de Médicos ===");
        if (cantidadMedicos == 0) {
            System.out.println("No hay médicos registrados en el sistema.");
        } else {
            for (int i = 0; i < cantidadMedicos; i++) {
                System.out.println("Médico " + (i + 1) + ": \n" + medicos[i].toString());
            }
        }
        System.out.println("========================\n");
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public Medico[] getMedicos() {
        return medicos;
    }

    public Cita[] getCitas() {
        return citas;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public int getCantidadMedicos() {
        return cantidadMedicos;
    }

    public int getCantidadCitas() {
        return cantidadCitas;
    }
}