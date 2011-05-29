package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.protocol.http.WebApplication;

public class DevappVista extends WebApplication {
    public DevappVista() {
    }

    @Override
    public Class getHomePage() {
        return Page1.class;
    }
}