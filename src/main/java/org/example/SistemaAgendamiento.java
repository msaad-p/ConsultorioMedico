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
     * Retorna un usuario del arreglo de usuarios según su ID.
     * 
     * Recorre el arreglo usuarios hasta encontrar igualdad de IDs.
     * 
     * Input: idBuscar El ID del Usuario que se desea buscar.
     * Output: El usuario si fue encontrada; -1 si no se encontró ningún usuario con ese ID.
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
     * Retorna un médico del arreglo de médicos según su ID.
     * 
     * Recorre el arreglo medicos hasta encontrar igualdad de IDs.
     * 
     * Input: idBuscar El ID del médico que se desea buscar.
     * Output: El médico si fue encontrada; -1 si no se encontró ningún medico con ese ID.
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
     * Retorna una cita del arreglo de citas según su ID.
     * 
     * Recorre el arreglo citas hasta encontrar igualdad de IDs.
     * 
     * Input: idBuscar El ID de la cita que se desea buscar.
     * Output: La cita si fue encontrada; -1 si no se encontró ninguna cita con ese ID.
     */
        for (int i = 0; i < cantidadCitas; i++) {
            if (citas[i] != null && Objects.equals(citas[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private int eliminarCita(String idBuscar) {
    /*
     * Elimina una cita del arreglo de citas según su ID.
     * 
     * Busca la cita con el ID especificado. Si se encuentra:
     * - Se elimina desplazando todas las citas posteriores una posición a la izquierda.
     * - La última posición ocupada se establece en null para evitar duplicados.
     * 
     * Input: idBuscar El ID de la cita que se desea eliminar.
     * Output: 1 si la cita fue encontrada y eliminada; -1 si no se encontró ninguna cita con ese ID.
     */
        for (int i = 0; i < cantidadCitas; i++) {
            if (citas[i] != null && Objects.equals(citas[i].getId(), idBuscar)) {
                for (int j = i; j < (cantidadCitas-1); j++ ){
                    citas[i] = citas[i+1];
                }
                citas[cantidadCitas-1] = null;
                cantidadCitas--;
                return 1;
            }
        }
        return -1;
    }

    private int agregarUsuario(Usuario usuario) {
    /*
     * Agrega un usuario del arreglo de usuario dado un usuario.
     * 
     * Busca el usuario con el ID. 
     * Si se encuentra:
     * -Ya existe este usuario
     * Si se encuentra null:
     * Agrega al usuario a ese indice y aumenta la cantida de usuarios
     * Si no se encuenta:
     * Hay máximo de usuarios
     * 
     * Input: Instancia del usuario.
     * Output: Si se encuenta retorna -1, si se encuentra null retorna 1 y sino se encuentra retorna -1
     */
        String indice = usuario.getId();
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (Objects.equals(usuarios[i].getId(),indice)) { /*Ya existe el usuario */
                return -1;
            }
            else if(usuarios[i] == null){ /*Se encontró espacio para nuevo usuario */
                usuarios[i] = null;
                cantidadUsuarios++;
            }
        }
        return -1; /*No hay espacio para más usuarios */
    }

    private int agregarMedico(Medico medico) {
    /*
     * Agrega un medico del arreglo de medico dado un medico.
     * 
     * Busca el medico con el ID. 
     * Si se encuentra:
     * -Ya existe este medico
     * Si se encuentra null:
     * Agrega al medico a ese indice y aumenta la cantida de medicos
     * Si no se encuenta:
     * Hay máximo de medicos
     * 
     * Input: Instancia del medico.
     * Output: Si se encuenta retorna -1, si se encuentra null retorna 1 y sino se encuentra retorna -1
     */
        String indice = medico.getId();
        for (int i = 0; i < cantidadMedicos; i++) {
            if (Objects.equals(medicos[i].getId(),indice)) { /*Ya existe el médico */
                return -1;
            }
            else if(medicos[i] == null){ /*Se encontró espacio para nuevo médico */
                medicos[i] = null;
                cantidadMedicos++;
                return 1;
            }
        }
        return -1; /*No hay espacio para más médicos */
    }

    private int agregarCita(Cita cita) {
    /*
     * Agrega un cita del arreglo de cita dado un cita.
     * 
     * Busca el cita con el ID. 
     * Si se encuentra:
     * -Ya existe este cita.
     * Si se encuentra null:
     * Agrega al citas a ese indice y aumenta la cantida de citas.
     * Si no se encuenta:
     * Hay máximo de citas.
     * 
     * Input: Instancia de la cita.
     * Output: Si se encuenta retorna -1, si se encuentra null retorna 1 y sino se encuentra retorna -1
     */
        String indice = cita.getId();
        for (int i = 0; i < cantidadCitas; i++) {
            if (Objects.equals(citas[i].getId(),indice)) { /*Ya existe el cita */
                return -1;
            }
            else if(citas[i] == null){ /*Se encontró espacio para nuevo cita */
                citas[i] = null;
                cantidadCitas++;
                return 1;
            }
        }
        return -1; /*No hay espacio para más citas */
    }

    private void  mostrarCitasGlobal() {
    /*
     * Mostrar todas la citas de forma global.
     * 
     * Recorre todas las citas y los imprime en el formato:
     * === Citas Global ===
     * "1.|Id: |Fecha:  |Hora:  |Paciente:  |Médico:
     * "2.|Id: |Fecha:  |Hora:  |Paciente:  |Médico:
     *  .
     *  .
     *  .
     * ======================"
     * 
     * Input: Nada.
     * Output: Si se encuenta retorna -1, si se encuentra null retorna 1 y sino se encuentra retorna -1
     */
        System.out.println("=== Citas Global ===");
        for (int i = 0; i < cantidadCitas; i++) {
        System.out.println((i+1) +".|Id:"+ citas[i].getId() +"|Fecha:"+ citas[i].getFecha() +"|Hora:"+ citas[i].getHora() +"|Paciente:"+ citas[i].getPaciente().getNombre() +"|Médico:"+ citas[i].getMedico().getNombre());
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
