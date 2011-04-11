package ar.edu.unq.partnersdevapp.dominio.personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;

/**
 * TODO: description
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

    public void addPlanDeCarrera(final Date fechaInicio, final PlanDeCarrera planDeCarrera,
            final Posicion posicionInicial) {
        this.getInfoPlanDeCarrera().add(new InfoPlanDeCarrera(fechaInicio, planDeCarrera, posicionInicial));
    }

    // TODO: verificar errores, lista vacia,
    public Posicion getPosicionActual() {
        Collections.sort(this.getInfoPlanDeCarrera());
        int ultimaElemento = this.getInfoPlanDeCarrera().size() - 1;
        return this.getInfoPlanDeCarrera().get(ultimaElemento).getNivelPlanDeCarrera();
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

    public List<InfoPlanDeCarrera> getInfoPlanDeCarrera() {
        return infoPlanDeCarrera;
    }

    public void setInfoPlanDeCarrera(final List<InfoPlanDeCarrera> infoPlanDeCarrera) {
        this.infoPlanDeCarrera = infoPlanDeCarrera;
    }

}
