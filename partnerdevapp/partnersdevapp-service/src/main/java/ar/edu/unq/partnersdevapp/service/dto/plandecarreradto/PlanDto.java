package ar.edu.unq.partnersdevapp.service.dto.plandecarreradto;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 * TODO: description
 */
public class PlanDto implements Dto {

    private static final long serialVersionUID = 1L;

    private int id = 0;// NOPMD

    private String especialidad = "";

    private String descripcion = "";

    @Override
    public String toString() {
        return this.getEspecialidad();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(final String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {// NOPMD
        this.id = id;// NOPMD
    }

}
