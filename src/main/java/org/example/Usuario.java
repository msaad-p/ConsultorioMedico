package org.example;

import java.util.Random;

public class Usuario {
    private String id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correoElectronico;
    private Cita[] citas;

    public Usuario(String nombre, String numeroIdentificacion, String telefono, String correoElectronico, Cita[] citas) {
        this.id = "U-"+(new Random().nextInt(9000)+1000);
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.citas = citas;
    }
}
