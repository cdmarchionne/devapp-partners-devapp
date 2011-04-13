package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 * -Modela la idea de bandas. Con 0 subBandas [0,100] - Con 1 subBandas [0,100]
 * -Con 2 subBandas [0,50,100] - Con 3 subBandas [0,33,66,100] , etc...
 * 
 * @author leo
 */
public class SubNivel {

    static final int ANCHOBANDA = 100;

    private float cantidadDeSubNiveles;

    public SubNivel(final int cantidadDeSubBandas) {
        this.setCantidadDeSubNiveles(cantidadDeSubBandas);
    }

    public List<Integer> getBandas() {
        List<Integer> list = new ArrayList<Integer>();
        float posicion = 0;
        float salto = this.getSalto();

        while (posicion < 99) {
            list.add((int) posicion);
            posicion = posicion + salto;
        }
        list.add(ANCHOBANDA);
        return list;
    }

    /**
     * Ej: Si la banda es [0,50,100] su actual es 50 , entonces devuelve 100.
     * Pero su fuera 100 devuelve -1.
     * */

    public int getSubNivelSuperior(final int subNivel) {
        int res;
        res = (int) (subNivel == ANCHOBANDA ? -1 : subNivel + this.getSalto());
        res = res > 98 ? 100 : res;
        return res;

    }

    private float getSalto() {
        float salto;
        if (this.getCantidadDeSubNiveles() == 0) {
            salto = ANCHOBANDA;
        } else {
            salto = ANCHOBANDA / this.getCantidadDeSubNiveles();
        }
        return salto;
    }

    // **********************
    // ***** Gets & Sets
    public float getCantidadDeSubNiveles() {
        return cantidadDeSubNiveles;
    }

    public void setCantidadDeSubNiveles(final float cantidadDeSubNiveles) {
        this.cantidadDeSubNiveles = cantidadDeSubNiveles;
    }

}
