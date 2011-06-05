package ar.edu.unq.partnersdevapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;

/**
 * TODO: description
 */
public class NivelDao {

    public NivelDao() {
        super();
    }

    /** Pedirle a la base todos los niveles */
    public List<Nivel> getAll() {
        List<Nivel> list = new ArrayList<Nivel>();
        list.add(BaseDeDatosHelper.getNivelJunior());
        list.add(BaseDeDatosHelper.getNiveLlider());
        return list;
    }
}
