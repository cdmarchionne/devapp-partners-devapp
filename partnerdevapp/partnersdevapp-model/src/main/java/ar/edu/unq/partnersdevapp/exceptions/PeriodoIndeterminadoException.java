package ar.edu.unq.partnersdevapp.exceptions;

/**
 * Ayuda para la captura. no se deberia poder asignar una licencia a alguien que
 * tiene una licencia indeterminada.
 */
public class PeriodoIndeterminadoException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Tiene fecha de inicio , pero no de fin";
    }

}
