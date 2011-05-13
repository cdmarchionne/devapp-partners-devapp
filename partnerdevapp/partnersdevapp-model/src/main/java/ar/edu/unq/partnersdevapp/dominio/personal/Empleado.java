package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarreraManager;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaManager;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * PONER DESCRIPCION
 */
public class Empleado extends Persona {

    private String obraSocial;

    private String planPrapaga;

    private String nombreArt;

    private Integer telArt;

    private String dirArt;

    private Date fechaIngreso;// Esta podria ser la fecha del primer plan de
                              // carrera

    private PlanDeCarreraManager planDeCarreraManager = new PlanDeCarreraManager();

    private LicenciaManager licenciaManager = new LicenciaManager();

    private Skills conocimiento;

    public Empleado() {
        super();
    }

    public Empleado(final String nombre, final String apellido, final String dni) {
        super(nombre, apellido, dni);
    }

    public Empleado(final String nombre, final String apellido, final String dni, final Date fechaIngreso,
            final Skills conocimiento) {
        this(nombre, apellido, dni);
        this.fechaIngreso = (Date) fechaIngreso.clone();
        this.conocimiento = conocimiento;
    }

    /**
     * Calcula el sueldo teniendo en cuenta la posicion actual
     * 
     * @throws NoHayResultadoException
     */

    public float getSueldo() throws NoHayResultadoException {
        return this.getPlanDeCarreraManager().getPlanActual()
                .getSueldo(this.getPlanDeCarreraManager().getPosicionActual());
    }

    // ******************
    // ****** Gets & Sets
    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(final String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getPlanPrapaga() {
        return planPrapaga;
    }

    public void setPlanPrapaga(final String planPrapaga) {
        this.planPrapaga = planPrapaga;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(final String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public Integer getTelArt() {
        return telArt;
    }

    public void setTelArt(final Integer telArt) {
        this.telArt = telArt;
    }

    public String getDirArt() {
        return dirArt;
    }

    public void setDirArt(final String dirArt) {
        this.dirArt = dirArt;
    }

    public Date getFechaIngreso() {
        return (Date) fechaIngreso.clone();
    }

    public void setFechaIngreso(final Date fechaIngreso) {
        this.fechaIngreso = (Date) fechaIngreso.clone();
    }

    public Skills getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(final Skills conocimiento) {
        this.conocimiento = conocimiento;
    }

    public PlanDeCarreraManager getPlanDeCarreraManager() {
        return planDeCarreraManager;
    }

    public void setPlanDeCarreraManager(final PlanDeCarreraManager planDeCarreraManager) {
        this.planDeCarreraManager = planDeCarreraManager;
    }

    public LicenciaManager getLicenciaManager() {
        return licenciaManager;
    }

    public void setLicenciaManager(final LicenciaManager licenciaManager) {
        this.licenciaManager = licenciaManager;
    }

}
