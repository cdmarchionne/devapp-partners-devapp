package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.personal.Cliente;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;

/**
 * TODO: description
 */
public class Proyecto {

    private static final Integer HORAS_DIARIAS_TRABAJADAS = 8;

    private static final Integer HORAS_MENSUALES_TRABAJADAS = 21 * HORAS_DIARIAS_TRABAJADAS;

    private String nombre;

    private Cliente cliente;

    private Skills conocimientosNecesarios;

    private Integer esfuerzoEstimado;

    private Set<Empleado> personalAsignado;

    private Map<Empleado, Integer> horasHombre;

    public Proyecto(final String nombre, final Cliente cliente, final Skills conocimientosNecesarios,
            final Integer esfuerzoEstimado) {
        super();
        this.nombre = nombre;
        this.cliente = cliente;
        this.conocimientosNecesarios = conocimientosNecesarios;
        this.esfuerzoEstimado = esfuerzoEstimado;
        personalAsignado = new HashSet<Empleado>();
        horasHombre = new HashMap<Empleado, Integer>();
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public Skills getConocimientosNecesarios() {
        return conocimientosNecesarios;
    }

    public void setConocimientosNecesarios(final Skills conocimientosNecesarios) {
        this.conocimientosNecesarios = conocimientosNecesarios;
    }

    public boolean faltaEsfuerzo() {
        return this.horasAsignadas() < esfuerzoEstimado;
    }

    private Integer horasAsignadas() {
        Integer horasTotales = 0;

        for (Integer horasPersonales : horasHombre.values()) {
            horasTotales += horasPersonales;
        }
        return horasTotales;
    }

    public Integer getEsfuerzoEstimado() {
        return esfuerzoEstimado;
    }

    public float getEsfuerzoDias() {
        return !personalAsignado.isEmpty() ? (float) esfuerzoEstimado
                / (personalAsignado.size() * HORAS_DIARIAS_TRABAJADAS) : -1;
    }

    public float getEsfuerzoMensual() {
        return !personalAsignado.isEmpty() ? esfuerzoEstimado / (personalAsignado.size() * HORAS_MENSUALES_TRABAJADAS)
                : -1;
    }

    public void setEsfuerzoEstimado(final Integer esfuerzoEstimado) {
        this.esfuerzoEstimado = esfuerzoEstimado;
    }

    public Set<Empleado> getPersonalAsignado() {
        return personalAsignado;
    }

    private boolean esUnEmpleadoApto(final Empleado empleado) {
        return empleado.getConocimiento().satisfaceRequisito(conocimientosNecesarios);
    }

    /**
     * Agrego un Empleado a un Proyecto e indico que trabajara en el durante
     * cierta cantidad de horas
     */
    public boolean addEmpleadoManual(final Empleado empleado, final Integer cantidadHoras) {
        boolean agregar = this.faltaEsfuerzo() && this.esUnEmpleadoApto(empleado);

        if (agregar) {
            personalAsignado.add(empleado);
            horasHombre.put(empleado, cantidadHoras);
        }
        return agregar;
    }

    private boolean condicionesEmpleadoAutomatico(final Empleado empleado) {
        return this.esUnEmpleadoApto(empleado);
    }

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

    public Map<Empleado, Integer> getHorasHombre() {
        return horasHombre;
    }

    public void setHorasHombre(final Map<Empleado, Integer> horasHombre) {
        this.horasHombre = horasHombre;
    }

}
