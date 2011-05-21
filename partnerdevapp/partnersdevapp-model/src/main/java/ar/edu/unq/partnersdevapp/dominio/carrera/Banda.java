package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * -Modela la idea de bandas. Con 1 subBandas [100] - Con 2 subBandas [0,100]
 * -Con 3 subBandas [0,50,100] - Con 4 subBandas [0,33,66,100] , etc...
 * 
 * @author leo
 */
public class Banda extends Entidad {

    private static final int ANCHO_BANDA = 100;

    private int cantidadDeSubBandas;

    public Banda() {
    }

    public Banda(final int cantidadDeSubBandas) {
        this.setCantidadDeSubBandas(cantidadDeSubBandas);
    }

    public List<Integer> getBandas() {
        List<Integer> list = new ArrayList<Integer>();

        if (cantidadDeSubBandas > 0) {
            int salto = this.getSalto();

            for (int i = 0; i < cantidadDeSubBandas - 1; i++) {
                list.add(i * salto);
            }
            list.add(ANCHO_BANDA);
        }
        return list;
    }

    /**
     * Ej: Si la banda es [0,50,100] su actual es 50 , entonces devuelve 100.
     * Pero si fuera 100 devuelve -1.
     * */
    public int getSubNivelSuperior(final int subNivel) {
        List<Integer> bandas = this.getBandas();
        int indexOfSubNivelSuperior = bandas.indexOf(subNivel) + 1;

        return !bandas.isEmpty() && indexOfSubNivelSuperior < bandas.size() ? bandas.get(indexOfSubNivelSuperior) : -1;
    }

    private int getSalto() {
        int salto;
        if (this.getCantidadDeSubBandas() <= 1) {
            salto = ANCHO_BANDA;
        } else {
            salto = ANCHO_BANDA / (this.getCantidadDeSubBandas() - 1);
        }
        return salto;
    }

    // **********************
    // ***** Gets & Sets
    public int getCantidadDeSubBandas() {
        return cantidadDeSubBandas;
    }

    public void setCantidadDeSubBandas(final int cantidadDeSubNiveles) {
        cantidadDeSubBandas = cantidadDeSubNiveles;
    }

}
