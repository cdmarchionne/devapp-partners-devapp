package ar.edu.unq.partnersdevapp.service.empleado;

import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.persistencia.dao.personal.LicenciaDao;

/**
 */
public class LicenciaService {

    private LicenciaDao licenciaDao;

    public void save(final LicenciaTipo model) {
        licenciaDao.save(model);
    }

    public List<LicenciaTipo> findAll() {
        return licenciaDao.findAll();
    }

    public void setLicenciaDao(final LicenciaDao licenciaDao) {
        this.licenciaDao = licenciaDao;
    }

    public LicenciaDao getLicenciaDao() {
        return licenciaDao;
    }

}
