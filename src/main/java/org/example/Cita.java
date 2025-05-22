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
        this.id = "C-"+(new Random().nextInt(9000)+1000);
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

}
