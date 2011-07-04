package ar.edu.unq.partnersdevapp.dominio.personal;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Clase utilizada para manejar de forma completa las Direcciones de calles
 */
public class Direccion extends Entidad {

    private static final long serialVersionUID = 1L;

    private String calle;

    private Integer altura;

    private String piso;

    private String depto;

    private String localidad;

    private String codigoPostal;

    private String provincia;

    private String pais;

    public Direccion() {
        super();
    }

    public Direccion(final String calle, final Integer altura) {
        super();
        this.calle = calle;
        this.altura = altura;
    }

    public Direccion(final String calle, final Integer altura, final String localidad) {
        super();
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }

    public Direccion(final String calle, final Integer altura, final String piso, final String depto,
            final String localidad, final String codigoPostal, final String provincia, final String pais) {
        super();
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(final String calle) {
        this.calle = calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(final Integer altura) {
        this.altura = altura;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(final String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(final String depto) {
        this.depto = depto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(final String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(final String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(final String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(final String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return calle + " " + altura;
    }

    // public String toFullString() {
    // StringBuffer direccion = new StringBuffer(this.toString());
    // if (!piso.isEmpty()) {
    // direccion.append(", Piso: " + piso);
    // }
    // if (!depto.isEmpty()) {
    // direccion.append(" Dto: " + depto);
    // }
    // if (!codigoPostal.isEmpty()) {
    // direccion.append("(CP: " + codigoPostal + ")");
    // }
    // if (!localidad.isEmpty()) {
    // direccion.append(". " + localidad);
    // }
    // if (!provincia.isEmpty()) {
    // direccion.append(". " + provincia);
    // }
    // if (!pais.isEmpty()) {
    // direccion.append(". " + pais);
    // }
    //
    // return direccion.toString();
    // }
}
