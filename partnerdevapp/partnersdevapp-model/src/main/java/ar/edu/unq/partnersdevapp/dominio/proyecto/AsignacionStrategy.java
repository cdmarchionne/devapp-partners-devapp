package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.dominio.personal.EmpleadoPrioridad;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * TODO: Asignacion Automatica en Construccion
 */
public class AsignacionStrategy {

    private Proyecto proyecto;

    @SuppressWarnings("PMD")
    private Map<Empleado, Integer> horasHombre;

    public AsignacionStrategy(final Proyecto proyecto) {
        super();
        this.proyecto = proyecto;
        horasHombre = new HashMap<Empleado, Integer>();
    }

    protected Proyecto getProyecto() {
        return proyecto;
    }

    protected void setProyecto(final Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * Agrego un Empleado a un Proyecto e indico que trabajara en el durante
     * cierta cantidad de horas
     */
    public void addEmpleadoManual(final Empleado empleado) {
        Integer cantidadHoras = 0;
        if (!getProyecto().getPersonalAsignado().contains(empleado)) {
            getProyecto().addPersonal(empleado);
            horasHombre.put(empleado, cantidadHoras);
        }
    }

    public boolean faltaEsfuerzo() {
        return horasAsignadas() < getProyecto().getEsfuerzoEstimado();
    }

    /** Cantidad de horas que el Proyecto tiene asignadas con empleados */
    private Integer horasAsignadas() {
        Integer horasTotales = 0;

        for (Integer horasPersonales : horasHombre.values()) {
            horasTotales += horasPersonales;
        }
        return horasTotales;
    }

    /**
     * Calculo de cantidad minima de personal para dedicarse exclusivamente al
     * proyecto toda la jornada
     */
    public Integer cantPersonalMinimo() {
        int diasHabiles = 0;
        try {
            diasHabiles = proyecto.getFecha().getDiasConsecutivos();
        } catch (PeriodoIndeterminadoException e) {
            throw new UnsupportedOperationException(e);
        }
        return proyecto.getEsfuerzoEstimado() / (diasHabiles * FechaUtils.HORAS_DIARIAS_TRABAJADAS);
    }

    /** Condiciones necesarias para que un Empleado trabaje en un proyecto */
    private boolean condicionesEmpleadoAutomatico(final Empleado empleado) {
        return esUnEmpleadoApto(empleado) && !diasLibres(empleado).isEmpty();
    }

    /** Verifico si el empleado es apto para el proyecto */
    private boolean esUnEmpleadoApto(final Empleado empleado) {
        return empleado.getConocimiento().satisfaceRequisito(getProyecto().getRequerimientos());
    }

    /** Verifico si el empleado es apto para el proyecto */
    private Integer diferenciaRequisitosDelEmpleado(final Empleado empleado) {
        return empleado.getConocimiento().diferenciaRequisitos(getProyecto().getRequerimientos());
    }

    /** Dias libres del empleado en la fecha de realizacion del proyecto */
    private List<Date> diasLibres(final Empleado empleado) {
        List<Date> diasLibres;
        try {
            diasLibres = empleado.diasLibres(proyecto.getFecha());
        } catch (PeriodoIndeterminadoException e) {
            throw new UnsupportedOperationException();
        }
        return diasLibres;
    }

    /** Recomendacion Automatica de empleados sin Calsificacion x Prioridad */
    public Set<Empleado> getEmpleadosAutomatico(final Set<Empleado> empleados) {
        Set<Empleado> empleadosCandidatos = new HashSet<Empleado>();
        Empleado empleadoParticular;

        Iterator<Empleado> iterador = empleados.iterator();
        while (iterador.hasNext()) {
            empleadoParticular = iterador.next();
            if (condicionesEmpleadoAutomatico(empleadoParticular)) {
                empleadosCandidatos.add(empleadoParticular);
            }
        }
        return empleadosCandidatos;
    }

    /** Recomendacion Automatica de empleados con Calsificacion x Prioridad */
    public Set<EmpleadoPrioridad> getEmpleadosAutomaticoPriority(final Set<Empleado> empleados) {
        Set<EmpleadoPrioridad> empleadosCandidatos = new HashSet<EmpleadoPrioridad>();
        Empleado empleadoParticular;
        Integer diferenciaDeRequisitos;
        List<Date> diasLibres;
        EmpleadoPrioridad empleadoPrioridad;

        Iterator<Empleado> iterador = empleados.iterator();
        while (iterador.hasNext()) {
            empleadoParticular = iterador.next();
            diasLibres = diasLibres(empleadoParticular);
            diferenciaDeRequisitos = diferenciaRequisitosDelEmpleado(empleadoParticular);

            if (diferenciaDeRequisitos >= 0 && !diasLibres.isEmpty()) {
                empleadoPrioridad = new EmpleadoPrioridad(empleadoParticular, diferenciaDeRequisitos, diasLibres.size());
                empleadosCandidatos.add(empleadoPrioridad);
            }
        }
        return empleadosCandidatos;
    }

}
