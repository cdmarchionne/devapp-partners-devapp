package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.dominio.personal.EmpleadoPrioridad;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Asignacion De empleados a Proyectos de forma Manual y Automatica
 */
public class AsignacionStrategy {

    private Proyecto proyecto;

    private Map<Empleado, Integer> horasHombre;// NOPMD

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
    public void addEmpleadoManual(final Empleado empleado, final List<FechasXcomprension> diasAsignados) {
        Integer cantidadHoras = 0;
        if (!this.getProyecto().getPersonalAsignado().contains(empleado)) {
            this.getProyecto().addPersonal(empleado);
            for (FechasXcomprension fecha : diasAsignados) {
                cantidadHoras += this.horasProductivas(fecha);
            }
            horasHombre.put(empleado, cantidadHoras);
            empleado.getProyectoManager().addProyecto(proyecto, diasAsignados);
        }
    }

    public void addEmpleadoManual(final Empleado empleado) {
        this.addEmpleadoManual(empleado, FechaUtils.crearFechaXcomprension(this.diasLibres(empleado)));
    }

    public boolean faltaEsfuerzo() {
        return this.horasAsignadas() < this.getProyecto().getEsfuerzoEstimado();
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
        return proyecto.getEsfuerzoEstimado() / this.horasProductivas(proyecto.getFecha());
    }

    /** Calculo de la cantidad de horas Hombre en n dias */
    private int horasProductivas(final int diasHabiles) {
        return diasHabiles * FechaUtils.HORAS_DIARIAS_TRABAJADAS;
    }

    private int horasProductivas(final FechasXcomprension fecha) {
        int diasHabiles = 0;
        try {
            diasHabiles = fecha.getDiasConsecutivos();
        } catch (PeriodoIndeterminadoException e) {
            throw new UnsupportedOperationException(e);
        }
        return this.horasProductivas(diasHabiles);
    }

    /** Condiciones necesarias para que un Empleado trabaje en un proyecto */
    private boolean condicionesEmpleadoAutomatico(final Empleado empleado) {
        return this.esUnEmpleadoApto(empleado) && !this.diasLibres(empleado).isEmpty();
    }

    /** Verifico si el empleado es apto para el proyecto */
    private boolean esUnEmpleadoApto(final Empleado empleado) {
        return empleado.getConocimiento().satisfaceRequisito(this.getProyecto().getRequerimientos());
    }

    /** Verifico si el empleado es apto para el proyecto */
    private Integer diferenciaRequisitosDelEmpleado(final Empleado empleado) {
        return empleado.getConocimiento().diferenciaRequisitos(this.getProyecto().getRequerimientos());
    }

    /** Dias libres del empleado en la fecha de realizacion del proyecto */
    private List<Date> diasLibres(final Empleado empleado) {
        List<Date> diasLibres = null;
        try {
            diasLibres = empleado.diasLibres(proyecto.getFecha());
        } catch (PeriodoIndeterminadoException e) {
            diasLibres = new ArrayList<Date>();
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
            if (this.condicionesEmpleadoAutomatico(empleadoParticular)) {
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
            diasLibres = this.diasLibres(empleadoParticular);
            diferenciaDeRequisitos = this.diferenciaRequisitosDelEmpleado(empleadoParticular);

            if (diferenciaDeRequisitos >= 0 && !diasLibres.isEmpty()) {
                empleadoPrioridad = new EmpleadoPrioridad(empleadoParticular, diferenciaDeRequisitos, diasLibres.size());
                empleadosCandidatos.add(empleadoPrioridad);
            }
        }
        return empleadosCandidatos;
    }

}
