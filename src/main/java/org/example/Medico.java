package org.example;

import java.util.Random;

public class Medico {
    private String id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correoElectronico;
    private Cita[] citas = new Cita[25];
    private int cantidadCitasMedico = 0;

    public Medico(String nombre, String numeroIdentificacion, String telefono, String correoElectronico, Cita[] citas) {
        this.id = "M-"+String.format("%04d",new Random().nextInt(10000));
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.citas = citas;
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

    public int getCantidadCitasMedico() {
        return cantidadCitasMedico;
    }

    public Cita[] getCitas() {
        return citas;
    }
}
