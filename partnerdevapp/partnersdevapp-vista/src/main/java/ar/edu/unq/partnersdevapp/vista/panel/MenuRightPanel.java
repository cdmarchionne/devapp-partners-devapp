package ar.edu.unq.partnersdevapp.vista.panel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * Los menu de la derecha deben heredar de esta clase. Deben tener su html
 * asociado de la forma "MenuRightPanelTemplate.html"
 */
public abstract class MenuRightPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public MenuRightPanel(final String entidad) {
        super(entidad + "MenuRight");
        this.addLinks();
    }

    abstract public void addLinks();

}
