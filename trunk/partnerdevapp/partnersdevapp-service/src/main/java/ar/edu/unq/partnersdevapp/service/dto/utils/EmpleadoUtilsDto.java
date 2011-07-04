package ar.edu.unq.partnersdevapp.service.dto.utils;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.service.dto.personal.EmpleadoDto;

/**
 * TODO: description
 */
public class EmpleadoUtilsDto {

    static public Empleado dtoToReal(final EmpleadoDto dto) {
        Empleado empleado = new Empleado(dto.getNombre(), dto.getApellido(), dto.getDni());
        empleado.setFechaNacimiento(dto.getFechaNacimiento());
        empleado.setId(dto.getId());
        return empleado;
    }

    static public EmpleadoDto realToDto(final Empleado realObject) {
        EmpleadoDto dto = new EmpleadoDto();
        dto.setNombre(realObject.getNombre());
        dto.setApellido(realObject.getApellido());
        dto.setDni(realObject.getDni());
        dto.setFechaNacimiento(realObject.getFechaNacimiento());
        dto.setId(realObject.getId());
        return dto;
    }

    static public List<EmpleadoDto> realToDto(final List<Empleado> list) {
        List<EmpleadoDto> newList = new ArrayList<EmpleadoDto>();
        if (list != null) {
            for (Empleado empleado : list) {
                newList.add(EmpleadoUtilsDto.realToDto(empleado));
            }
        }
        return newList;
    }

}
