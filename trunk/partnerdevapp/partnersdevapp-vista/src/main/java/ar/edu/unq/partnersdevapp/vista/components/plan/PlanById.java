package ar.edu.unq.partnersdevapp.vista.components.plan;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;

import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.components.PanelFilter;
import ar.edu.unq.partnersdevapp.vista.components.TextFieldWithLabel;
import ar.edu.unq.partnersdevapp.vista.models.ModelFilterPlanByID;
import ar.edu.unq.partnersdevapp.vista.models.ModelTable;

/**
 * Panel con opciones de filtrado.
 */
public class PlanById extends PanelFilter<PlanDto, PlanService> {

    private static final long serialVersionUID = 1L;

    private ModelFilterPlanByID modelFilter;

    public PlanById(final ModelTable<PlanDto> aModelTable, final PlanService service,
            final List<Component> componentList) {
        super(aModelTable, componentList);
        this.setService(service);
    }

    @Override
    public void setModels() {
        modelFilter = new ModelFilterPlanByID();
    }

    /**
     * Ejecuta la busqueda. Si hiciera falta agregar el metodo correspondiente
     * al servicio.
     */
    @Override
    public List<PlanDto> getNewData() {
        List<PlanDto> list = new ArrayList<PlanDto>();
        int aidi = Integer.parseInt(this.getModelFilter().getId());
        list.add(this.getService().findById(aidi));
        return list;
    }

    /** Componentes para criterio de busqueda. Hacer corresponder con el Html. */
    @Override
    public void addInputs() {
        this.add(new TextFieldWithLabel(this.getModelFilter(), "id", false));
    }

    public void setModelFilter(final ModelFilterPlanByID modelFilter) {
        this.modelFilter = modelFilter;
    }

    public ModelFilterPlanByID getModelFilter() {
        return modelFilter;
    }

}
