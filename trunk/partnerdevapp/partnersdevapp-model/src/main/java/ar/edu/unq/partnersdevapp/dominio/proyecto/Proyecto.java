package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.personal.Cliente;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;

/**
 * TODO: Asignacion Automatica de Personas
 */
@SuppressWarnings("unused")
public class Proyecto {

    @SuppressWarnings("PMD")
    private String nombre;

    private Cliente cliente;

    private Skills requerimientos;

    // Cantidad de Horas de trabajo necesarias para realizar el Proyecto
    private Integer esfuerzoEstimado;

    @SuppressWarnings("PMD")
    private Set<Empleado> personalAsignado;

    private FechasXcomprension fecha;

    private transient AsignacionStrategy asignacion;

    public Proyecto(final String nombre, final Cliente cliente, final Skills skillMinimos,
            final Integer esfuerzoEstimado) {
        super();
        this.nombre = nombre;
        this.cliente = cliente;
        requerimientos = skillMinimos;
        this.esfuerzoEstimado = esfuerzoEstimado;
        personalAsignado = new HashSet<Empleado>();
        asignacion = new AsignacionStrategy(this);
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

    public Skills getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(final Skills skillMinimos) {
        requerimientos = skillMinimos;
    }

    protected FechasXcomprension getFecha() {
        return fecha;
    }

    protected void setFecha(final FechasXcomprension fecha) {
        this.fecha = fecha;
    }

    public Integer getEsfuerzoEstimado() {
        return esfuerzoEstimado;
    }

    public void setEsfuerzoEstimado(final Integer esfuerzoEstimado) {
        this.esfuerzoEstimado = esfuerzoEstimado;
    }

    public Set<Empleado> getPersonalAsignado() {
        return personalAsignado;
    }

    public void addPersonal(final Empleado empleado) {
        personalAsignado.add(empleado);
    }

    public Set<Empleado> getEmpleadosAutomatico(final Set<Empleado> empleados) {
        return asignacion.getEmpleadosAutomatico(empleados);
    }

}
