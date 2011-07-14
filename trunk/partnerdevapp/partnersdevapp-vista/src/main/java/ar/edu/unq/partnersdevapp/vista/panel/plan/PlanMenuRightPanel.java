package ar.edu.unq.partnersdevapp.vista.panel.plan;

import org.apache.wicket.markup.html.link.Link;

import ar.edu.unq.partnersdevapp.vista.pages.plan.AltaPlan;
import ar.edu.unq.partnersdevapp.vista.pages.plan.PlanSelectPage;
import ar.edu.unq.partnersdevapp.vista.panel.MenuRightPanel;

/**
 * Menu derecha para plan de carrera
 */
public class PlanMenuRightPanel extends MenuRightPanel {

    private static final long serialVersionUID = 1L;

    public PlanMenuRightPanel() {
        super("plan");
    }

    @Override
    public void addLinks() {
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
