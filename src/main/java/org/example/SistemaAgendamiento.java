package org.example;

public class SistemaAgendamiento {
    private Usuario[] usuarios = new Usuario[25];
    private Medico[] medicos = new Medico[25];
    private Cita[] citas = new Cita[50];
    private int cantidadUsuarios = 0;
    private int cantidadMedicos = 0;
    private int cantidadCitas = 0;

    public SistemaAgendamiento() {
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
