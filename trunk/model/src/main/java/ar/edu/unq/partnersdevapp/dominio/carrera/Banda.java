package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 * -Modela la idea de bandas. Con 0 subBandas [0,100] - Con 1 subBandas [0,100]
 * -Con 2 subBandas [0,50,100] - Con 3 subBandas [0,33,66,100] , etc...
 * 
 */
public class Banda {

    int CantidadDeSubBandas;

    public Banda(final int cantidadDeSubBandas) {
        this.setCantidadDeSubBandas(cantidadDeSubBandas);
    }

    public List<Integer> getBandas() {
        List<Integer> list = new ArrayList<Integer>();
        int posicion = 0;
        int salto;
        if (this.getCantidadDeSubBandas() == 0) {
            salto = 100;
        } else {
            salto = 100 / this.getCantidadDeSubBandas();
        }

        while (posicion < 99) {
            list.add(posicion);
            posicion = posicion + salto;
        }
        list.add(100);
        return list;
    }

    public int getCantidadDeSubBandas() {
        return CantidadDeSubBandas;
    }

    public void setCantidadDeSubBandas(final int cantidadDeSubBandas) {
        CantidadDeSubBandas = cantidadDeSubBandas;
    }

}
