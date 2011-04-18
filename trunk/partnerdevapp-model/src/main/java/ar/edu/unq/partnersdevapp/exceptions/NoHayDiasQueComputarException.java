package ar.edu.unq.partnersdevapp.exceptions;

/**
 * TODO: description
 */
public class NoHayDiasQueComputarException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "La lista de días esta vacía";
    }

}
