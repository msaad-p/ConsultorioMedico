package org.example;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

public class Cita {
    private String id;
    private Date fecha;
    private Time hora;
    private Usuario paciente;
    private Medico medico;

    public Cita(Date fecha, Time hora, Usuario paciente, Medico medico) {
        this.id = "C-"+String.format("%04d",new Random().nextInt(10000));
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }


    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getId() {
        return id;
    }
}
