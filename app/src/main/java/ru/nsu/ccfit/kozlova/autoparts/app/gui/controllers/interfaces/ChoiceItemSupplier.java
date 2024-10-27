package ru.nsu.ccfit.kozlova.autoparts.app.gui.controllers.interfaces;


import ru.nsu.ccfit.kozlova.autoparts.app.gui.custom.ChoiceItem;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ChoiceItemSupplier<X> {
    Collection<ChoiceItem<X>> getItems() throws Exception;

    default ChoiceItemSupplier<X> mergeWith(ChoiceItemSupplier<X> otherSupplier) {
        return () -> Stream.of(this.getItems(), otherSupplier.getItems())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}