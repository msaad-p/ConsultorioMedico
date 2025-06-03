package org.example;

import java.util.Random;

public class Usuario {
    protected String id;
    protected String nombre;
    protected long numeroIdentificacion;
    protected long telefono;
    protected String correoElectronico;
    protected Cita[] citas = new Cita[25];
    private int cantidadCitasUsuario = 0;

    public Usuario(String nombre, long numeroIdentificacion, long telefono, String correoElectronico) {
        this.id = "U-" + String.format("%04d", new Random().nextInt(10000));
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        return  "    ID: " + id +
                "\n    Nombre: " + nombre +
                "\n    Número de Identificación: " + numeroIdentificacion +
                "\n    Teléfono: " + telefono +
                "\n    Correo Electrónico: " + correoElectronico +
                "\n";
    }
}