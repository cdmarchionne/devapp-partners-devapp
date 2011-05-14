package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
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
    public void addEmpleadoManual(final Empleado empleado, final Integer cantidadHoras) {
        if (!getProyecto().getPersonalAsignado().contains(empleado)) {
            getProyecto().addPersonal(empleado);
            horasHombre.put(empleado, cantidadHoras);
        }
    }

    public boolean faltaEsfuerzo() {
        return horasAsignadas() < getProyecto().getEsfuerzoEstimado();
    }

    private Integer horasAsignadas() {
        Integer horasTotales = 0;

        for (Integer horasPersonales : horasHombre.values()) {
            horasTotales += horasPersonales;
        }
        return horasTotales;
    }

    public Integer cantPersonalMinimo() {
        int diasHabiles;
        try {
            diasHabiles = proyecto.getFecha().getDiasConsecutivos();
        } catch (PeriodoIndeterminadoException e) {
            throw new UnsupportedOperationException(e);
        }
        return proyecto.getEsfuerzoEstimado() / (diasHabiles * FechaUtils.HORAS_DIARIAS_TRABAJADAS);
    }

    private boolean esUnEmpleadoApto(final Empleado empleado) {
        return empleado.getConocimiento().satisfaceRequisito(getProyecto().getRequerimientos());
    }

    private boolean condicionesEmpleadoAutomatico(final Empleado empleado) {
        return esUnEmpleadoApto(empleado);
        // Revisra que este presente
    }

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

}
