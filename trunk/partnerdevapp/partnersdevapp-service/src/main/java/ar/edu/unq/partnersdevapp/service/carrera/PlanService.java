package ar.edu.unq.partnersdevapp.service.carrera;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.persistencia.dao.carrera.PlanDao;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelDto;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.service.dto.utils.NivelUtilsDto;
import ar.edu.unq.partnersdevapp.service.dto.utils.PlanUtilsDto;

/**
 * TODO: description
 */
public class PlanService implements Serializable {

    private static final long serialVersionUID = 1L;

    private PlanDao planDao;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** Manejar exepcion si no hay datos */
    public PlanDto findById(final Serializable id) {
        return PlanUtilsDto.objectToDto(planDao.findById(id));
    }

    public void save(final PlanDto model) {
        planDao.save(PlanUtilsDto.dtoToObject(model));
    }

    public List<PlanDto> findAll() {
        return PlanUtilsDto.objectToDto(planDao.findAll());
    }

    /**
     * Agrega el nivel al plan
     * 
     * @param seleccion
     *            : a que plan
     * @param modelNivel
     *            : el nivel nuevo
     * @param value
     *            : si es anterior o posterior a nivel del siguiente parametro
     * @param seleccion2
     *            : nivel existente
     */
    // ??? usando logica de dominio en servicio y logica al servicio
    @Transactional
    public void agregarNivel(final PlanDto seleccion, final NivelDto modelNivel, final String value,
            final NivelDto seleccion2) {
        PlanDeCarrera plan = planDao.findById(seleccion.getId());
        Nivel nivelNuevo = NivelUtilsDto.dtoToReal(modelNivel);
        Nivel nivelExistente = new Nivel();

        if (seleccion2 != null) {
            nivelExistente = NivelUtilsDto.dtoToReal(seleccion2);
        }
        try {
            if (value.equals("0")) {
                plan.addNivelAnterior(nivelNuevo, nivelExistente);
            }
            if (value.equals("1")) {
                plan.addNivelPosterior(nivelNuevo, nivelExistente);
            }
        } catch (NoHayResultadoException e) {
            throw new UnsupportedOperationException();
        }

        planDao.update(plan);
    }

    public PlanDao getPlanDao() {
        return planDao;
    }

    public void setPlanDao(final PlanDao planDao) {
        this.planDao = planDao;
    }

}
