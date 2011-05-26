package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * TODO: description
 */
public class VistaMain extends WebApplication {

    @Override
    public Class<Index> getHomePage() {
        return Index.class;
    }

}
