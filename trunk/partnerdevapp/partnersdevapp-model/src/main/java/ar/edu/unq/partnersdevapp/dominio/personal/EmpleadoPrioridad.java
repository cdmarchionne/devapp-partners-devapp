package ar.edu.unq.partnersdevapp.dominio.personal;

/**
 * Informacion de soporte para la asignacion automatica de Empleados a Proyectos
 */
public class EmpleadoPrioridad {

    private Empleado empleado;

    private Integer requisitos;

    private Integer cantDiasLibres;

    public EmpleadoPrioridad(final Empleado empleado, final Integer requisitos, final Integer cantDiasLibres) {
        super();
        this.empleado = empleado;
        this.requisitos = requisitos;
        this.cantDiasLibres = cantDiasLibres;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(final Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(final Integer requisitos) {
        this.requisitos = requisitos;
    }

    public Integer getCantDiasLibres() {
        return cantDiasLibres;
    }

    public void setCantDiasLibres(final Integer cantDiasLibres) {
        this.cantDiasLibres = cantDiasLibres;
    }
}
