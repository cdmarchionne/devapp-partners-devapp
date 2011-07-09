package ar.edu.unq.partnersdevapp.service.dto.utils;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.carrera.Banda;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.NivelDto;

/**
 * ver de hacer la convercion con reflec
 */
public class NivelUtilsDto {
    private NivelUtilsDto() {
        throw new UnsupportedOperationException();
    }

    public static Nivel dtoToReal(final NivelDto dto) {
        Nivel nivel = new Nivel(dto.getNombre(), new Banda(dto.getBanda()), dto.getSueldoMaximo(),
                dto.getSueldoMinimo());
        nivel.setId(dto.getId());
        return nivel;
    }

    public static NivelDto realToDto(final Nivel realObject) {
        NivelDto niveldto = new NivelDto(realObject.getNombre(), realObject.getBanda().getCantidadDeSubBandas(),
                realObject.getSueldoMaximo(), realObject.getSueldoMinimo());
        niveldto.setId(realObject.getId());
        return niveldto;
    }

    public static List<NivelDto> realToDto(final List<Nivel> list) {
        List<NivelDto> newList = new ArrayList<NivelDto>();
        if (list != null) {
            for (Nivel nivel : list) {
                newList.add(NivelUtilsDto.realToDto(nivel));
            }
        }
        return newList;
    }

}
