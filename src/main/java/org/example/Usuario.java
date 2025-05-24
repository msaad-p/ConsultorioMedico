package org.example;

import java.util.Random;

public class Usuario {
    private String id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correoElectronico;
    private Cita[] citas = new Cita[25];
    private int cantidadCitasUsuario = 0;

    public Usuario(String nombre, String numeroIdentificacion, String telefono, String correoElectronico, Cita[] citas) {
        this.id = "U-"+String.format("%04d",new Random().nextInt(10000));
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.citas = citas;
    }

    private void  mostrarCitas() {
    /*
     * Mostrar todas la citas de forma local del usuario.
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
        for (int i = 0; i < cantidadCitasUsuario; i++) {
        System.out.println((i+1) +".|Id:"+ citas[i].getId() +"|Fecha:"+ citas[i].getFecha() +"|Hora:"+ citas[i].getHora() +"|Paciente:"+ citas[i].getPaciente().getNombre() +"|Médico:"+ citas[i].getMedico().getNombre());
        }
        System.out.println("======================");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getId() {
        return id;
    }

    public Cita[] getCitas() {
        return citas;
    }

    public int getCantidadCitasUsuario() {
        return cantidadCitasUsuario;
    }
}
