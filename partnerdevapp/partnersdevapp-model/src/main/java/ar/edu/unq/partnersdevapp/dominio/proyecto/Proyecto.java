package ar.edu.unq.partnersdevapp.dominio.proyecto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;
import ar.edu.unq.partnersdevapp.dominio.personal.Cliente;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;

/**
 * Administracion de Proyectos
 */

public class Proyecto extends Entidad {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private Cliente cliente;

    private Skills requerimientos;

    // Cantidad de Horas de trabajo necesarias para realizar el Proyecto
    private Integer esfuerzoEstimado;

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

    public FechasXcomprension getFecha() {
        return fecha;
    }

    public void setFecha(final FechasXcomprension fecha) {
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

    public void addEmpleadoManual(final Empleado empleado) {
        asignacion.addEmpleadoManual(empleado);
    }

    public void addEmpleadoManual(final Empleado empleado, final List<FechasXcomprension> diasAsignados) {
        asignacion.addEmpleadoManual(empleado, diasAsignados);
    }

    public Set<Empleado> getEmpleadosAutomatico(final Set<Empleado> empleados) {
        return asignacion.getEmpleadosAutomatico(empleados);
    }

    @Override
    public boolean equals(final Object obj) {
        // return proyecto == null ? false : getNombre().equals(((Proyecto)
        // obj).getNombre());
        boolean rta = false;

        if (!(obj == null || this.getClass() != obj.getClass())) {
            if (this == obj) {
                rta = true;
            } else {
                Proyecto proyecto = (Proyecto) obj;
                rta = this.getNombre() == null ? proyecto.getNombre() == null : this.getNombre().equals(
                        proyecto.getNombre());
            }
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 10 + this.getNombre() == null ? 0 : this.getNombre().hashCode();
    }

    public AsignacionStrategy getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(final AsignacionStrategy asignacion) {
        this.asignacion = asignacion;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setPersonalAsignado(final Set<Empleado> personalAsignado) {
        this.personalAsignado = personalAsignado;
    }

}
