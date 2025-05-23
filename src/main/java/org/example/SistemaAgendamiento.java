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
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null && Objects.equals(usuarios[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private int buscarMedico(String idBuscar) {
        for (int i = 0; i < cantidadMedicos; i++) {
            if (medicos[i] != null && Objects.equals(medicos[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    private int buscarCita(String idBuscar) {
        for (int i = 0; i < cantidadCitas; i++) {
            if (citas[i] != null && Objects.equals(citas[i].getId(), idBuscar)) {
                return i;
            }
        }
        return -1;
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
