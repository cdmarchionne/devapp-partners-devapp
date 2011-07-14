package ar.edu.unq.partnersdevapp.vista.panel.plan;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.service.carrera.PlanService;
import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.panel.FilterPanel;
import ar.edu.unq.partnersdevapp.vista.panel.InputPanel;

/**
 *
 */
public class PlanFilterPanel extends FilterPanel<PlanDto, PlanService> {

    private static final long serialVersionUID = 1L;

    InputPanel txwl;

    public PlanFilterPanel(final PlanDto aModel, final PlanService aSevice) {
        super("plan", aModel, aSevice);
    }

    @Override
    public List<PlanDto> getFilterData() throws NoHayResultadoException {
        int valueId = Integer.parseInt(txwl.getValue());

        List<PlanDto> list = new ArrayList<PlanDto>();
        list.add(this.getService().findById(valueId));

        return list;
    }

    @Override
    public void addInputs() {
        txwl = new InputPanel(this.getModel(), "id", false);
        this.add(txwl);
    }
}
