package ar.edu.unq.partnersdevapp.vista.components;

import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.PropertyModel;

import ar.edu.unq.partnersdevapp.vista.models.ModelCombo;

/**
 * Usa el ModelCombo que es generico Al name pasado por parametro le agrega el
 * String combo. "nameCombo"
 * 
 * @param <T>
 */
public class Combo<T> extends DropDownChoice<T> {

    private static final long serialVersionUID = 1L;

    public Combo(final String name, final ModelCombo<T> model) {
        super(name + "Combo", new PropertyModel<T>(model, "seleccion"), new PropertyModel<List<T>>(model, "opciones"));
    }

}
