package ar.edu.unq.partnersdevapp.dominio.personal;

/**
 * PONER DESCRIPCION
 */
public class Persona {

    private String nombre;

    private String apellido;

    private String dni;

    private String direccion;

    private String localidad;

    private String telefono;

    private String email;

    private String universidad;

    public Persona() {
        throw new UnsupportedOperationException();
    }

    public Persona(final String nombre, final String apellido, final String dni, final String direccion,
            final String localidad, final String telefono, final String email, final String universidad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.email = email;
        this.universidad = universidad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(final String localidad) {
        this.localidad = localidad;
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

}
