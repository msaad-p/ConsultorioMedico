package org.example;

import java.util.Random;

public class Medico extends Usuario {

    public Medico(String nombre, long numeroIdentificacion, long telefono, String correoElectronico) {
        super(nombre, numeroIdentificacion, telefono, correoElectronico);
        this.id = "M-" + String.format("%04d", new Random().nextInt(10000));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}