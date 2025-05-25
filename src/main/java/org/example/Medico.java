package org.example;

import java.util.Date;
import java.util.Random;
import java.sql.Time;
import java.util.Calendar;

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

    private void  mostrarCitas() {
    /*
     * Mostrar todas la citas de forma local del médico.
     * 
     * Recorre todas las citas y los imprime.
     * Input: Nada.
     * Output: Muestra las citas.
     */
        System.out.println("\n=== Citas del médico "+nombre+" ===");
        for (int i = 0; i < cantidadCitasMedico; i++) {
            String citaprint = citas[i].toString();
            System.out.println("Cita "+(i+1)+": \n"+citaprint);
        }
        System.out.println("======================");
    }

    private int verificarDisponibilidad(Date fecha,Time hora) {
    /* 
    La descripción para el lector
     */
        for (int i = 0; i < cantidadCitasMedico; i++) {
            if(citas[i] == null){
                break;
            }
        Calendar citaEvaluarInicio = Calendar.getInstance();
        citaEvaluarInicio.setTime(citas[i].getFecha());
        citaEvaluarInicio.set(Calendar.HOUR_OF_DAY, citas[i].getHora().getHours());
        citaEvaluarInicio.set(Calendar.MINUTE, citas[i].getHora().getMinutes());
        citaEvaluarInicio.set(Calendar.SECOND, citas[i].getHora().getSeconds());
        citaEvaluarInicio.set(Calendar.MILLISECOND, 0);
        Date fechaHoraInicio = citaEvaluarInicio.getTime();

        Calendar citaDada = Calendar.getInstance();
        citaDada.setTime(fecha);
        citaDada.set(Calendar.HOUR_OF_DAY, hora.getHours());
        citaDada.set(Calendar.MINUTE, hora.getMinutes());
        citaDada.set(Calendar.SECOND, hora.getSeconds());
        citaDada.set(Calendar.MILLISECOND, 0);
        Date fechaHoraComparar = citaDada.getTime();
        Calendar citaEvaluarFinal = (Calendar) citaEvaluarInicio.clone();
        citaEvaluarFinal.add(Calendar.HOUR_OF_DAY, 1);
        Date fechaHoraLimite = citaEvaluarFinal.getTime();
        if (!fechaHoraComparar.before(fechaHoraInicio) && fechaHoraComparar.before(fechaHoraLimite)){ /*Niega el primer before para que sea after xd */
        return 1;
        }
    }
    return -1;
            
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

    public void setCantidadCitasMedico(int cantidadCitasMedico) {
        this.cantidadCitasMedico = cantidadCitasMedico;
    }

    public Cita[] getCitas() {
        return citas;
    }
}
