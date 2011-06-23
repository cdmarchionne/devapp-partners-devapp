package ar.edu.unq.partnersdevapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;

/**
 * 
 */
public class NivelDao extends HibernateDaoSupport {

    /**
     * Pedirle a la base todos los niveles
     * 
     * ++DB implementar
     * */

    public List<Nivel> findAll() {
        List<Nivel> list = new ArrayList<Nivel>();
        list.add(BaseDeDatosHelper.getNivelJunior());
        list.add(BaseDeDatosHelper.getNiveLlider());
        return list;
    }

}
