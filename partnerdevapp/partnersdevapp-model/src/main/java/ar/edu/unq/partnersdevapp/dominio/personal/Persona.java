package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Datos Personales
 */
public class Persona extends Entidad {

    private static final long serialVersionUID = 1L;

    protected String nombre;

    protected String apellido;

    private Date fechaNacimiento;

    protected String dni;

    protected Direccion direccion;

    protected String telefono;

    protected String email;

    protected String universidad;

    public Persona(final String nombre, final String apellido, final String dni) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Persona(final String nombre, final String apellido, final String dni, final Date fecha,
            final String direccion, final Integer altura, final String localidad, final String telefono,
            final String email, final String universidad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        fechaNacimiento = fecha;
        this.dni = dni;
        this.direccion = new Direccion(direccion, altura, localidad);
        this.telefono = telefono;
        this.email = email;
        this.universidad = universidad;
    }

    public Persona() {
        super();
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(final String dni) {
        this.dni = dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(final String calle, final Integer altura) {
        direccion = new Direccion(calle, altura);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(final String universidad) {
        this.universidad = universidad;
    }

    public void setFechaNacimiento(final Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setDireccion(final Direccion direccion) {
        this.direccion = direccion;
    }

}
