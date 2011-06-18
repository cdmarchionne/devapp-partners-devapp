package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.wicket.Page;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.partnersdevapp.vista.pages.Page1;

/**
 * 
 * 
 */
public class RunApplication extends AuthenticatedWebApplication {

    private transient MounterURL aMounterURL;

    private LogService logService;

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(final LogService logService) {
        this.logService = logService;
    }

    @Override
    public void init() {
        aMounterURL = new MounterURL(this);
        this.addComponentInstantiationListener(new SpringComponentInjector(this));
    }

    // private void mountUrl(final String mountPath, final Class<? extends
    // WebPage> pageClass, final String... parameters) {
    // aMounterURL.mount(mountPath, pageClass, parameters);
    // }

    @Override
    protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
        return WebSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return Page1.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Page1.class;
    }

    public String getContextPath() {
        return this.getServletContext().getContextPath();
    }

    public void setaMounterURL(final MounterURL aMounterURL) {
        this.aMounterURL = aMounterURL;
    }

    public MounterURL getaMounterURL() {
        return aMounterURL;
    }
}
