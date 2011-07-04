package ar.edu.unq.partnersdevapp.service.carrera;

import java.io.Serializable;
import java.util.List;

import ar.edu.unq.partnersdevapp.persistencia.dao.carrera.NivelDao;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelDto;
import ar.edu.unq.partnersdevapp.service.dto.utils.NivelUtilsDto;

/**
 * servicio para persistir nivel
 */
public class NivelService implements Serializable {

    private static final long serialVersionUID = 1L;

    private NivelDao nivelDao;

    public List<NivelDto> findAll() {
        return NivelUtilsDto.realToDto(this.getNivelDao().findAll());
    }

    public List<NivelDto> findByPlanid(final int id) {
        return NivelUtilsDto.realToDto(nivelDao.findByIdPlanId(id));
    }

    public void save(final NivelDto nivelDto) {
        this.getNivelDao().save(NivelUtilsDto.dtoToReal(nivelDto));
    }

    // G y S
    public NivelDao getNivelDao() {
        return nivelDao;
    }

    public void setNivelDao(final NivelDao nivelDao) {
        this.nivelDao = nivelDao;
    }
}
