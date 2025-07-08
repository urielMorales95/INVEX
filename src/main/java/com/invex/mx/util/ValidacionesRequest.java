package com.invex.mx.util;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidacionesRequest {

    public List<Map<String, Object>> getListaErrores(List<FieldError> errores){
        List<Map<String, Object>> listaErrores = new ArrayList<>();

        for (FieldError o: errores) {
            Map<String, Object> map = new HashMap<>();
            map.put("campo",o.getField());
            map.put("mensaje", o.getDefaultMessage());
            listaErrores.add(map);
        }

        return listaErrores;
    }

}
