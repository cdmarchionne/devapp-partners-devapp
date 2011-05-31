package ar.edu.unq.partnersdevapp.vista.service;

import org.apache.wicket.Page;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class TestApplication extends AuthenticatedWebApplication {

    private MounterURL aMounterURL;

    private LogService logService;

    public LogService getLogService() {
        return logService;
    }

    public void setGeneralService(final LogService logService) {
        this.logService = logService;
    }

    public TestApplication() {

    }

    @Override
    public void init() {
        aMounterURL = new MounterURL(this);
        this.addComponentInstantiationListener(new SpringComponentInjector(this));
    }

    private void mountUrl(final String mountPath, final Class<? extends WebPage> pageClass, final String... parameters) {
        aMounterURL.mount(mountPath, pageClass, parameters);
    }

    @Override
    protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
        return WebSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return Home.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Home.class;
    }

    public String getContextPath() {
        return this.getServletContext().getContextPath();
    }

}
