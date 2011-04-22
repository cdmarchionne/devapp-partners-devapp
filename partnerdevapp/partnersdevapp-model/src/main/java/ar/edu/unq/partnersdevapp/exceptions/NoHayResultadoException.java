package ar.edu.unq.partnersdevapp.exceptions;

/**
 * 
 */
public class NoHayResultadoException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "No hay datos que satisfacen";
    }

}
