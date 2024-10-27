package ru.nsu.ccfit.kozlova.autoparts.app.gui.forms.input;

import javafx.stage.Stage;
import ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces.SuccessAction;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;

public interface EntityInputFormBuilder<E extends Entity, CR, UR> {

    Stage buildCreationFormWindow(SuccessAction onSuccessAction);

    Stage buildEditFormWindow(E entity, SuccessAction onSuccessAction);

    Stage buildContextCreationFormWindow(CR createRequest, SuccessAction onSuccessAction);

    Stage buildContextEditFormWindow(E entity, SuccessAction onSuccessAction);

}
