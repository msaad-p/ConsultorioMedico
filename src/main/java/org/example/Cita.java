package org.example;

import java.sql.Time;
import java.text.SimpleDateFormat;
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

    public Time getHora() {
        return hora;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        return  "    ID: " + id +
                "\n    Fecha: " + dateFormat.format(fecha) +
                "\n    Hora: " + timeFormat.format(hora) +
                "\n    Paciente: " + paciente.getNombre() +
                "\n    Médico: " + medico.getNombre() +
                "\n";
    }
}
