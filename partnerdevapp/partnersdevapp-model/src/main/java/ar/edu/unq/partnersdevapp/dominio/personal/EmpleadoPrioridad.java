package ar.edu.unq.partnersdevapp.dominio.personal;

/**
 * TODO: description
 */
public class EmpleadoPrioridad {

    private transient Empleado empleado;

    private transient Integer requisitos;

    private transient Integer cantDiasLibres;

    public EmpleadoPrioridad(final Empleado empleado, final Integer requisitos, final Integer cantDiasLibres) {
        super();
        this.empleado = empleado;
        this.requisitos = requisitos;
        this.cantDiasLibres = cantDiasLibres;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Integer getRequisitos() {
        return requisitos;
    }

    public Integer getCantDiasLibres() {
        return cantDiasLibres;
    }

}
