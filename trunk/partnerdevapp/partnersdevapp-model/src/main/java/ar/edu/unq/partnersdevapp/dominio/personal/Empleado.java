package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
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

    private Date fechaIngreso;

    private List<InfoPlanDeCarrera> infoPlanDeCarrera = new ArrayList<InfoPlanDeCarrera>();

    private Skills conocimiento;

    public Empleado(final String nombre, final String apellido, final String dni) {
        super(nombre, apellido, dni);
    }

    public Empleado(final String nombre, final String apellido, final String dni, final Date fechaIngreso,
            final List<InfoPlanDeCarrera> infoPlanDeCarrera, final Skills conocimiento) {
        this(nombre, apellido, dni);
        this.fechaIngreso = (Date) fechaIngreso.clone();
        this.infoPlanDeCarrera = infoPlanDeCarrera;
        this.conocimiento = conocimiento;
    }

    /** Agrega un informacion nueva de su plan de carrera. */
    public void addPlanDeCarrera(final Date fechaInicio, final PlanDeCarrera planDeCarrera,
            final Posicion posicionInicial) {
        getInfoPlanDeCarrera().add(new InfoPlanDeCarrera(fechaInicio, planDeCarrera, posicionInicial));
    }

    /**
     * Calcula el sueldo teniendo en cuenta la posicion actual
     * 
     * @throws NoHayResultadoException
     */
    public float getSueldo() throws NoHayResultadoException {
        return getPlanActual().getSueldo(getPosicionActual());
    }

    /**
     * Sube solo una posicon en el plan de carrera.
     * 
     * @throws NoHayResultadoException
     */
    public void subirPosicion() throws NoHayResultadoException {
        this.subirPosicion(Calendar.getInstance().getTime());
    }

    public void subirPosicion(final Date date) throws NoHayResultadoException {
        Posicion posicionNueva = getPlanActual().getPosicionSuperior(getPosicionActual());
        addPlanDeCarrera(date, getPlanActual(), posicionNueva);
    }

    /** Devuelve la ultima posicion en el plan de carrera actual */
    public Posicion getPosicionActual() throws NoHayResultadoException {
        return getUltimaInfo().getNivelPlanDeCarrera();
    }

    /**
     * Devuelve el último plan de carrera
     * 
     * @throws NoHayResultadoException
     */
    public PlanDeCarrera getPlanActual() throws NoHayResultadoException {
        return getUltimaInfo().getPlanDeCarrera();
    }

    /** Devuelve la informacion correspondiente al ultimo plan de carrera */
    private InfoPlanDeCarrera getUltimaInfo() throws NoHayResultadoException {
        Collections.sort(getInfoPlanDeCarrera());
        int ultimoElemento = getInfoPlanDeCarrera().size() - 1;
        if (ultimoElemento < 0) {
            throw new NoHayResultadoException();
        }
        return getInfoPlanDeCarrera().get(ultimoElemento);
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

    public List<InfoPlanDeCarrera> getInfoPlanDeCarrera() {
        return infoPlanDeCarrera;
    }

    public void setInfoPlanDeCarrera(final List<InfoPlanDeCarrera> infoPlanDeCarrera) {
        this.infoPlanDeCarrera = infoPlanDeCarrera;
    }

}
