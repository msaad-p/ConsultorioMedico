package org.example;

import java.util.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Random;

public class Medico extends Usuario {
    private int cantidadCitasMedico = 0;

    public Medico(String nombre, long numeroIdentificacion, long telefono, String correoElectronico) {
        super(nombre, numeroIdentificacion, telefono, correoElectronico);
        this.id = "M-" + String.format("%04d", new Random().nextInt(10000));
    }

    public int getCantidadCitasMedico() {
        return cantidadCitasMedico;
    }

    public void setCantidadCitasMedico(int cantidadCitasMedico) {
        this.cantidadCitasMedico = cantidadCitasMedico;
    }

    public boolean verificarDisponibilidad(Date fecha, Time hora) {
        /*
         * Verifica si un horario específico (fecha y hora) se superpone con alguna de las citas existentes de un médico.
         * Se asume que cada cita existente tiene una duración fija de una hora.
         * Retorna 'false' si el horario solicitado se cruza con una cita ya agendada, indicando que el horario NO está disponible.
         * Retorna 'true' si el horario está completamente libre y no hay superposición con ninguna cita existente, indicando que el horario SÍ está disponible.
         */
        for (int i = 0; i < cantidadCitasMedico; i++) {
            if (citas[i] == null) {
                /* Si se encuentra un elemento nulo, se asume que no hay más citas
                 * registradas después de este punto en el arreglo, por lo que se detiene la búsqueda. */
                break;
            }

            /* Configurar el objeto Calendar para el inicio de la cita existente (citas[i]). */
            Calendar citaEvaluarInicio = Calendar.getInstance();
            citaEvaluarInicio.setTime(citas[i].getFecha());
            citaEvaluarInicio.set(Calendar.HOUR_OF_DAY, citas[i].getHora().getHours());
            citaEvaluarInicio.set(Calendar.MINUTE, citas[i].getHora().getMinutes());
            citaEvaluarInicio.set(Calendar.SECOND, citas[i].getHora().getSeconds());
            citaEvaluarInicio.set(Calendar.MILLISECOND, 0);
            Date fechaHoraInicio = citaEvaluarInicio.getTime();

            /* Configurar el objeto Calendar para la fecha y hora que se desea comparar/verificar. */
            Calendar citaDada = Calendar.getInstance();
            citaDada.setTime(fecha);
            citaDada.set(Calendar.HOUR_OF_DAY, hora.getHours());
            citaDada.set(Calendar.MINUTE, hora.getMinutes());
            citaDada.set(Calendar.SECOND, hora.getSeconds());
            citaDada.set(Calendar.MILLISECOND, 0);
            Date fechaHoraComparar = citaDada.getTime();

            /* Clonar el inicio de la cita existente para calcular su hora de finalización.
             * Se le añade una hora para determinar el límite de la cita existente. */
            Calendar citaEvaluarFinal = (Calendar) citaEvaluarInicio.clone();
            citaEvaluarFinal.add(Calendar.HOUR_OF_DAY, 1); /* Asume que cada cita dura 1 hora. */
            Date fechaHoraLimite = citaEvaluarFinal.getTime();

            /* Verificar si la fecha y hora a comparar se superpone con el rango
             * de la cita existente. La superposición ocurre si la fechaHoraComparar
             * no es anterior al inicio de la cita existente Y es anterior al fin de la cita existente. */
            if (!fechaHoraComparar.before(fechaHoraInicio) && fechaHoraComparar.before(fechaHoraLimite)){
                /* Si hay superposición, el horario NO está disponible. */
                return false;
            }
        }
        /* Si el bucle termina sin encontrar ninguna superposición, el horario SÍ está disponible. */
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}