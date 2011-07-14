package ar.edu.unq.partnersdevapp.vista.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Crear su html correspondiente segun "HeaderPanelTemplate.html"
 */
public class HeaderPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public HeaderPanel(final String nombreEntidad, final String text) {
        super(nombreEntidad + "HeaderPanel");
        Label label = new Label(nombreEntidad + "HeaderLabel", text);
        this.add(label);
    }

}
