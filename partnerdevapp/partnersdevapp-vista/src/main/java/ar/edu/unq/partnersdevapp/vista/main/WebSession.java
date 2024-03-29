package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.Request;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.role.Roles;

public class WebSession extends AuthenticatedWebSession {

    public WebSession(final Request request) {
        super(request);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public boolean authenticate(final String username, final String password) {
        return true;
    }

    @Override
    public Roles getRoles() {
        Roles roles = new Roles();
        roles.add("root");
        return roles;
    }

}
