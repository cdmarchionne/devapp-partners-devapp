package ar.edu.unq.partnersdevapp.vista.pages.empleado;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.partnersdevapp.service.dto.personal.EmpleadoDto;
import ar.edu.unq.partnersdevapp.service.dto.utils.EmpleadoUtilsDto;
import ar.edu.unq.partnersdevapp.service.empleado.EmpleadoService;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 */
public class EmpleadoSelect extends BasePage {

    private List<EmpleadoDto> model;

    @SpringBean(name = "service.empleadoService")
    private EmpleadoService empleadoService;

    public EmpleadoSelect() {
        super();
        this.setModels();
    }

    @Override
    public void addMenuRight() {
        // throw new UnsupportedOperationException();
    }

    @Override
    public void addContent() {
        this.add(this.getListView());
    }

    public void setModels() {
        this.setModel(EmpleadoUtilsDto.realToDto(empleadoService.findAll()));
    }

    public WebMarkupContainer getListView() {
        WebMarkupContainer wmc = new WebMarkupContainer("containerTable");

        PropertyListView<EmpleadoDto> tablaResultado = new PropertyListView<EmpleadoDto>("tablaResultado", model) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<EmpleadoDto> item) {
                item.add(new Label("id"));
                item.add(new Label("nombre"));
                item.add(new Label("apellido"));
                item.add(new Label("fechaNacimiento"));
                item.add(new Label("dni"));
            }
        };
        wmc.add(tablaResultado);
        wmc.setOutputMarkupId(true);
        return wmc;
    }

    // -----------------------
    // -----Gets & Sets ------

    public void setModel(final List<EmpleadoDto> model) {
        this.model = model;
    }

    public List<EmpleadoDto> getModel() {
        return model;
    }

    public EmpleadoService getEmpleadoService() {
        return empleadoService;
    }

    public void setEmpleadoService(final EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Override
    public void addHeader() {
        throw new UnsupportedOperationException();
    }

}
