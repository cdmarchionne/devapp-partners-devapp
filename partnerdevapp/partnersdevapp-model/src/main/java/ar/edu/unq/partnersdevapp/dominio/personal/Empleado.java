package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarreraManager;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaManager;
import ar.edu.unq.partnersdevapp.dominio.proyecto.ProyectoManager;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * PONER DESCRIPCION
 */
public class Empleado extends Persona {

    private static final long serialVersionUID = 1L;

    private String obraSocial;

    private String planPrapaga;

    private String nombreArt;

    private Integer telArt;

    private String dirArt;

    private Date fechaIngreso;

    private PlanDeCarreraManager planDeCarreraManager = new PlanDeCarreraManager();

    private LicenciaManager licenciaManager = new LicenciaManager();

    private ProyectoManager proyectoManager = new ProyectoManager();

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
     * Calculo los dias libres que tiene para realizar un Proyecto Nuevo.
     * Recorro todas las Licencias y Proyectos que tiene asignados.
     */
    public List<Date> diasLibres(final FechasXcomprension fechaProyecto) throws PeriodoIndeterminadoException {
        List<Date> diasLibres = fechaProyecto.getFechasXextencion();
        Set<Date> fechasOcupado = new HashSet<Date>();

        for (FechasXcomprension fechasLicencia : this.getLicenciaManager().diasOcupados(fechaProyecto)) {
            fechasOcupado.addAll(fechasLicencia.getFechasXextencion());
        }

        for (FechasXcomprension fechasProyecto : this.getProyectoManager().diasOcupados(fechaProyecto)) {
            fechasOcupado.addAll(fechasProyecto.getFechasXextencion());
        }

        diasLibres.removeAll(fechasOcupado);
        return diasLibres;
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

    @Override
    public String toString() {
        return this.getId() + " " + this.getNombre();
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
        return fechaIngreso;
    }

    public void setFechaIngreso(final Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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

    public void setProyectoManager(final ProyectoManager proyectoManager) {
        this.proyectoManager = proyectoManager;
    }

    public ProyectoManager getProyectoManager() {
        return proyectoManager;
    }

}
