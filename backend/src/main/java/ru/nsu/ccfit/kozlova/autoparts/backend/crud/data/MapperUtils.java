package ru.nsu.ccfit.kozlova.autoparts.backend.crud.data;

import lombok.experimental.UtilityClass;

import java.util.function.Consumer;

public final class MapperUtils {

	private MapperUtils() {}

	public static <T> void setIfNotNull(T propertyValue, Consumer<T> propertySetter) {
		if (propertyValue != null) {
			propertySetter.accept(propertyValue);
		}
	}

}
