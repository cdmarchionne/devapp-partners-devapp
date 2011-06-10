package ar.edu.unq.partnersdevapp.vista.service;

import java.io.Serializable;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.persistencia.dao.NivelDao;
import ar.edu.unq.partnersdevapp.persistencia.dao.PlanDeCarreraDao;

/**
 * PlanBean
 */
public class PlanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PlanDeCarrera plan;

    private List<Nivel> nivelList;

    private transient NivelDao nivelDao;

    private transient PlanDeCarreraDao planDao;

    public PlanBean() {
        plan = new PlanDeCarrera("especialidad", "descripcion");
        nivelDao = new NivelDao();
        nivelList = nivelDao.getAll();
    }

    public void insert() {
        // System.out.println("ADD**" + this.getDescripcion());
        // this.getEspecialidad());
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

    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(final List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    public void setPlan(final PlanDeCarrera plan) {
        this.plan = plan;
    }

    public PlanDeCarrera getPlan() {
        return plan;
    }

    public void setPlanDao(final PlanDeCarreraDao planDao) {
        this.planDao = planDao;
    }

    public NivelDao getNivelDao() {
        return nivelDao;
    }

    public PlanDeCarreraDao getPlanDao() {
        return planDao;
    }

    public void setNivelDao(final NivelDao nivelDao) {
        this.nivelDao = nivelDao;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
