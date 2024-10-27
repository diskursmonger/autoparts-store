package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces;

import javafx.stage.Stage;
import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;

import java.io.IOException;

public interface ContextWindowBuilder<E extends Entity> {
    Stage buildWindow(E entity);
}