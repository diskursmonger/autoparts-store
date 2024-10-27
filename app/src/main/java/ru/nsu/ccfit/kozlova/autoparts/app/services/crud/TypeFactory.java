package ru.nsu.ccfit.kozlova.autoparts.app.services.crud;

import com.google.gson.reflect.TypeToken;
import ru.nsu.ccfit.kozlova.autoparts.app.services.crud.pagination.Page;

import java.lang.reflect.Type;
import java.util.List;

public class TypeFactory {

    public static <T> Type getListType(Class<T> elementClass) {
        Type elementType = TypeToken.get(elementClass).getType();
        return TypeToken.getParameterized(List.class, elementType).getType();
    }

    public static <T> Type getPageType(Class<T> elementClass) {
        Type elementType = TypeToken.get(elementClass).getType();
        return TypeToken.getParameterized(Page.class, elementType).getType();
    }

}