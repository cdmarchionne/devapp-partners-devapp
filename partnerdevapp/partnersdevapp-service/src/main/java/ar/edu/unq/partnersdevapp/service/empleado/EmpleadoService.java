package ar.edu.unq.partnersdevapp.service.empleado;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.exceptions.NoSeAsignoLicencia;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;
import ar.edu.unq.partnersdevapp.persistencia.dao.personal.EmpleadoDao;
import ar.edu.unq.partnersdevapp.service.defaultValue.Factory;

/**
 * TODO: description
 */
public class EmpleadoService {

    private EmpleadoDao empleadoDao;

    @Transactional
    public void asignar(final Empleado empleado, final LicenciaTipo licencia) throws NoHayResultadoException,
            PeriodoIndeterminadoException, NoSeAsignoLicencia {
        Empleado empleadoFromDb;
        empleadoFromDb = empleadoDao.findById(empleado.getId());

        empleadoFromDb.getLicenciaManager().addLicencia(licencia, Factory.getFxc());

        empleadoDao.update(empleadoFromDb);
    }

    public List<Empleado> findAll() {
        return empleadoDao.findAll();
    }

    public void setEmpleadoDao(final EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }
}
