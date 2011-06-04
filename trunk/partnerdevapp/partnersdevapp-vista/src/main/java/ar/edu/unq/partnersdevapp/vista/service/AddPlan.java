package ar.edu.unq.partnersdevapp.vista.service;

import java.io.Serializable;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;

/**
 * TODO: description
 */
public class AddPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    PlanDeCarrera plan = new PlanDeCarrera("especialidad", "descripcion");

    public AddPlan() {

    }

    public String getEspecialidad() {
        return plan.getEspecialidad();
    }

    public void setEspecialidad(final String especialidad) {
        plan.setEspecialidad(especialidad);
    }

    public String getDescripcion() {
        return plan.getDescripcion();
    }

    public void setDescripcion(final String descripcion) {
        plan.setDescripcion(descripcion);
    }

    public void add() {
        // System.out.println("ADD**" + this.getDescripcion() +
        // this.getEspecialidad());
    }

    // public List<Nivel> getNiveles() {
    // return niveles;
    // }
    //
    // public void setNiveles(final List<Nivel> niveles) {
    // this.niveles = niveles;
    // }

}
