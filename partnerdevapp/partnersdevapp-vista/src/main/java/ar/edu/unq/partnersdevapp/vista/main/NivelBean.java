package ar.edu.unq.partnersdevapp.vista.main;

import java.io.Serializable;
import java.util.List;

import ar.edu.unq.partnersdevapp.persistencia.dao.NivelDao;
import ar.edu.unq.partnersdevapp.service.dto.planDeCarreraDto.NivelDto;
import ar.edu.unq.partnersdevapp.service.dto.utils.NivelUtilsDto;

/**
 * servicio para persistir nivel
 */
public class NivelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    NivelDao nivelDao;

    public NivelBean() {
        nivelDao = new NivelDao();
    }

    public List<NivelDto> findAll() {
        return NivelUtilsDto.realToDto(this.getNivelDao().findAll());
    }

    public void insert() {
        System.out.println("**inserto");
    }

    // G y S
    public NivelDao getNivelDao() {
        return nivelDao;
    }

    public void setNivelDao(final NivelDao nivelDao) {
        this.nivelDao = nivelDao;
    }
}
