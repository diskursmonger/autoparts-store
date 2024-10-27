package ru.nsu.ccfit.kozlova.autoparts.app.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Entity implements Serializable, Cloneable {

    private Long id;

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    @Override
    @SneakyThrows
    public Entity clone() {
        return (Entity) super.clone();
    }

    static {
        propertyNames.put("id", "№");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

    public void calculateProperties() { }

}
