package ar.edu.unq.partnersdevapp.exceptions;

/**
 * TODO: description
 */
public class NoSeAsignoLicencia extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "La licencia no se asigno por que no cumple con los requisitos";
    }

}
