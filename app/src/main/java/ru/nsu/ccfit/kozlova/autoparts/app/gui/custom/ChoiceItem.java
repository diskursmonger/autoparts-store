package ru.nsu.ccfit.kozlova.autoparts.app.gui.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ChoiceItem<X> {

    @Getter
    private final X value;
    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

}