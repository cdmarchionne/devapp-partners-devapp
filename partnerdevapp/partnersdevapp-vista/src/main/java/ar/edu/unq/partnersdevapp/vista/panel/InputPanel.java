package ar.edu.unq.partnersdevapp.vista.panel;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * Es un componente<br>
 * Un contenedor con un label e inputText <br>
 * Ver ImputPanelTamplate.
 */

public class InputPanel extends WebMarkupContainer {
    private static final long serialVersionUID = 1L;

    private TextField<String> textField;

    public InputPanel(final Object model, final String campo, final boolean esRequerido) {
        super(campo + "InputContainer");
        this.add(new Label(campo + "Label", campo));
        this.add(this.crearTextField(model, campo, esRequerido));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TextField crearTextField(final Object model, final String campo, final boolean esRequerido) {
        PropertyModel property = new PropertyModel(model, campo);
        this.setTextField(new TextField(campo + "Field", property));
        if (esRequerido) {
            textField.setRequired(true);
        }
        return textField;
    }

    public String getValue() {
        return this.getTextField().getValue();
    }

    public void setTextField(final TextField<String> textField) {
        this.textField = textField;
    }

    public TextField<String> getTextField() {
        return textField;
    }
}
