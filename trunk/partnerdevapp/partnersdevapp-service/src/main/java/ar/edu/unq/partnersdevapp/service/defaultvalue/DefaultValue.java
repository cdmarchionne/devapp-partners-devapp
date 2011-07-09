package ar.edu.unq.partnersdevapp.service.defaultvalue;

import org.springframework.beans.factory.InitializingBean;

import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.persistencia.dao.carrera.NivelDao;
import ar.edu.unq.partnersdevapp.persistencia.dao.carrera.PlanDao;
import ar.edu.unq.partnersdevapp.persistencia.dao.personal.ClienteDao;
import ar.edu.unq.partnersdevapp.persistencia.dao.personal.EmpleadoDao;

/**
 * 
 */
public class DefaultValue implements InitializingBean {

    private PlanDao planDao;

    private NivelDao nivelDao;

    private EmpleadoDao empleadoDao;

    private ClienteDao clienteDao;

    /** se ejecuta cuando el spring factory crea el objeto */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.add();
    }

    public void add() {
        this.addPlan();
        this.addPersonas();
    }

    public void addPlan() {
        try {
            planDao.save(Factory.getPlan());
            planDao.save(Factory.getPlan2());
        } catch (NoHayResultadoException e) {
            throw new UnsupportedOperationException();
        }
    }

    /** empleados y clietes */
    public void addPersonas() {
        for (int i = 0; i < 50; i++) {
            empleadoDao.save(Factory.getEmpleado(i));
            clienteDao.save(Factory.getCliente(i));
        }

    }

    public PlanDao getPlanDao() {
        return planDao;
    }

    public void setPlanDao(final PlanDao planDao) {
        this.planDao = planDao;
    }

    public NivelDao getNivelDao() {
        return nivelDao;
    }

    public void setNivelDao(final NivelDao nivelDao) {
        this.nivelDao = nivelDao;
    }

    public void setEmpleadoDao(final EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(final ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

}
