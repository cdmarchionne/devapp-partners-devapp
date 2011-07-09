package ar.edu.unq.partnersdevapp.vista.components;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * Un contenedor con un label e inputText <br>
 * Template agregado como comentario.
 */

// ** reemplazar id por el pasado por parametro
// <div wicket:id="idContainer">
// <span wicket:id="idLabel" />
// <input wicket:id="idField" type="text" />
// </div>
public class TextFieldWithLabel extends MarkupContainer {
    private static final long serialVersionUID = 1L;

    private TextField<String> textField;

    public TextFieldWithLabel(final Object model, final String campo, final boolean esRequerido) {
        super(campo + "Container");
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
