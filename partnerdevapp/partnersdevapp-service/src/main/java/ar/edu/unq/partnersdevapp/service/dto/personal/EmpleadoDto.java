package ar.edu.unq.partnersdevapp.service.dto.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 
 */
public class EmpleadoDto implements Dto {

    private static final long serialVersionUID = 1L;

    protected int id; // NOPMD

    protected String nombre;

    protected String apellido;

    private Date fechaNacimiento;

    protected String dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(final Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(final String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) { // NOPMD
        this.id = id;// NOPMD
    }
}
