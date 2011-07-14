package ar.edu.unq.partnersdevapp.service.dto.utils;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;

/**
 * Conversiones de dto para <code>PlanDeCarrera</code>
 */
public class PlanUtilsDto {

    private PlanUtilsDto() {
    }

    public static void getget() {
    }

    public static PlanDeCarrera dtoToObject(final PlanDto dto) {
        PlanDeCarrera plan = new PlanDeCarrera(dto.getEspecialidad(), dto.getEspecialidad());
        plan.setId(dto.getId());
        return plan;
    }

    public static PlanDto objectToDto(final PlanDeCarrera plan) {
        PlanDto planDto = new PlanDto();
        planDto.setId(plan.getId());
        planDto.setEspecialidad(plan.getEspecialidad());
        planDto.setDescripcion(plan.getDescripcion());
        return planDto;
    }

    public static List<PlanDto> objectToDto(final List<PlanDeCarrera> planList) {
        List<PlanDto> listDto = new ArrayList<PlanDto>();
        for (PlanDeCarrera plan : planList) {
            listDto.add(PlanUtilsDto.objectToDto(plan));
        }
        return listDto;
    }
}
