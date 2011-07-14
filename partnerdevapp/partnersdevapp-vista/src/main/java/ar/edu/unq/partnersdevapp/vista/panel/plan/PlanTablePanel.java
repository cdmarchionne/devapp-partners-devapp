package ar.edu.unq.partnersdevapp.vista.panel.plan;

import java.util.List;

import ar.edu.unq.partnersdevapp.service.dto.plandecarreradto.PlanDto;
import ar.edu.unq.partnersdevapp.vista.models.ModelTable;
import ar.edu.unq.partnersdevapp.vista.panel.TablePanel;

/**
 * corresponde con PlanTablePanel
 */
public class PlanTablePanel extends TablePanel<PlanDto> {

    private static final long serialVersionUID = 1L;

    public PlanTablePanel(final String entidad, final ModelTable<PlanDto> aModelTable, final List<String> attributes) {
        super(entidad, aModelTable, attributes);
    }

}
