package ar.edu.unq.partnersdevapp.vista.components;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * TODO: description
 */
public class TextFieldWithLabel extends MarkupContainer {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("PMD")
    public TextFieldWithLabel(final String id) {
        super(id);
    }

    public TextFieldWithLabel(final Object model, final String campo, final boolean esRequerido) {
        super(campo + "Container");
        this.add(new Label(campo + "Label", campo));
        this.add(this.crearTextField(model, campo, esRequerido));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TextField crearTextField(final Object model, final String campo, final boolean esRequerido) {
        PropertyModel property = new PropertyModel(model, campo);
        TextField textField = new TextField(campo + "Field", property);
        if (esRequerido) {
            textField.setRequired(true);
        }
        return textField;
    }

}
