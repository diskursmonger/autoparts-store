package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces;

import ru.nsu.ccfit.kozlova.autoparts.app.model.Entity;

public interface ContextMenuAction<E extends Entity> {
    void run(E entity);
}
