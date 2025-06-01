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
     * Recorre todas las citas y los imprime.
     * Input: Nada.
     * Output: Muestra las citas.
     */
        System.out.println("\n=== Citas del paciente "+nombre+" ===");
        for (int i = 0; i < cantidadCitasUsuario; i++) {
            String citaprint = citas[i].toString();
            System.out.println("Cita "+(i+1)+": \n"+citaprint);
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

    public void setCantidadCitasUsuario(int cantidadCitasUsuario) {
        this.cantidadCitasUsuario = cantidadCitasUsuario;
    }
}