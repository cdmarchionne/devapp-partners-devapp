package ar.edu.unq.partnersdevapp.vista.components.plan;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;

import ar.edu.unq.partnersdevapp.vista.pages.plan.AltaPlan;
import ar.edu.unq.partnersdevapp.vista.pages.plan.PlanSelectPage;

/**
 * Especifica como sera el menu para la entidad Plan de carrera. Codigo Html
 * comentado.
 */
public class PlanMenuRight extends WebMarkupContainer {
    private static final long serialVersionUID = 1L;

    public PlanMenuRight() {
        super("menuRight");
        this.add(this.getLinkAlta());
        this.add(this.getLinkSelect());
    }

    protected Link<Object> getLinkAlta() {
        return new Link<Object>("altaLink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                this.setResponsePage(AltaPlan.class);
            }
        };
    }

    protected Link<Object> getLinkSelect() {
        return new Link<Object>("selectLink") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                this.setResponsePage(PlanSelectPage.class);
            }
        };
    }
}
