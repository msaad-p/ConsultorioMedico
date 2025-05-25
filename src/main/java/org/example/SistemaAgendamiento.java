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

    private int buscarUsuario(String idBuscar) {
    /*
     * Retorna la posición de un usuario del arreglo de usuarios según su ID.
     *
     * Recorre el arreglo usuarios hasta encontrar igualdad de IDs.
     *
     * Input: idBuscar El ID del Usuario que se desea buscar.
     * Output: La posición del usuario si fue encontrado; -1 si no se encontró ningún usuario con ese ID.
     */
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null && Objects.equals(usuarios[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private int buscarMedico(String idBuscar) {
    /*
     * Retorna la posición de un médico del arreglo de médicos según su ID.
     *
     * Recorre el arreglo médicos hasta encontrar igualdad de IDs.
     *
     * Input: idBuscar El ID del médico que se desea buscar.
     * Output: La posición del médico si fue encontrado; -1 si no se encontró ningún medico con ese ID.
     */
        for (int i = 0; i < cantidadMedicos; i++) {
            if (medicos[i] != null && Objects.equals(medicos[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private int buscarCita(String idBuscar) {
    /*
     * Retorna la posición de una cita del arreglo de citas según su ID.
     *
     * Recorre el arreglo citas hasta encontrar igualdad de IDs.
     *
     * Input: idBuscar El ID de la cita que se desea buscar.
     * Output: La posición de la cita si fue encontrada; -1 si no se encontró ninguna cita con ese ID.
     */
        for (int i = 0; i < cantidadCitas; i++) {
            if (citas[i] != null && Objects.equals(citas[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private boolean eliminarCita(String idBuscar) {
    /*
     * Elimina una cita del arreglo de citas según su ID.
     *
     * Busca la posición de la cita con el ID especificado. Si se encuentra:
     * - Se elimina desplazando todas las citas posteriores una posición a la izquierda.
     * - La última posición ocupada se establece en null para evitar duplicados.
     *
     * Input: idBuscar El ID de la cita que se desea eliminar.
     * Output: true si la cita fue encontrada y eliminada; false si no se encontró ninguna cita con ese ID.
     */
        int posicionEliminar = buscarCita(idBuscar);
        if (posicionEliminar == -1) {
            return false;
        }
        for (int i = posicionEliminar; i < (cantidadCitas-1); i++ ){
                citas[i] = citas[i+1];
            }
            citas[cantidadCitas-1] = null;
            cantidadCitas--;
            return true;
    }


    private boolean agregarUsuario(Usuario usuario) {
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

    private boolean agregarMedico(Medico medico) {
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

    private boolean agregarCita(Cita cita) {
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

        /* ACÁ DEBERÍA IR LA VALIDACIÓN DE LA VERIFICACIÓN DE LA DISPONIBILIDAD */

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

    private void  mostrarCitasGlobal() {
    /*
     * Mostrar todas la citas de forma global.
     * 
     * Recorre todas las citas y los imprime.
     * Input: Nada.
     * Output: Muestra las citas.
     */
        System.out.println("\n=== Citas Global ===");
        for (int i = 0; i < cantidadCitas; i++) {
            String citaprint = citas[i].toString();
            System.out.println("Cita "+(i+1)+": \n"+citaprint);
        }
        System.out.println("======================");
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
