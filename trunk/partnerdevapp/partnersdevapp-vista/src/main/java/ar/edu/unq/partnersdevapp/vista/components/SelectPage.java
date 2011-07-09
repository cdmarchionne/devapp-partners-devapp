package ar.edu.unq.partnersdevapp.vista.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.components.plan.PlanMenuRight;
import ar.edu.unq.partnersdevapp.vista.models.ModelTable;
import ar.edu.unq.partnersdevapp.vista.pages.BasePage;

/**
 * TODO: description
 * 
 * @param <T>
 * @param <S>
 */
public abstract class SelectPage<T, S> extends BasePage {

    private ModelTable<T> modelTable;

    public SelectPage() {
        super();
        this.iniciar();
    }

    @Override
    public void iniciar() {
        this.setModels();
        this.addContent();
        this.addMenuRight();
    }

    public abstract List<String> getAttributes();

    @Override
    public void addMenuRight() {
        this.add(new PlanMenuRight());
    }

    @Override
    public void addContent() {
        Form<T> form = new Form<T>("form");
        // tabla
        PanelTable<T> panelTable = this.getPanelTable();
        form.add(panelTable);
        // filtro
        List<Component> componentList = new ArrayList<Component>();
        componentList.add(panelTable);
        PanelFilter<T, S> FilterPanel = this.getPanelFilter(componentList);
        form.add(FilterPanel);
        this.add(form);
    }

    public abstract PanelTable<T> getPanelTable();

    public abstract PanelFilter<T, S> getPanelFilter(List<Component> componentList);

    @Override
    public abstract void setModels();

    public ModelTable<T> getModelTable() {
        return modelTable;
    }

    public void setModelTable(final ModelTable<T> modelTable) {
        this.modelTable = modelTable;
    }

    public PanelFilter<PlanDto, PlanService> getPanelFilter() {
        throw new UnsupportedOperationException();
    }
}
