package com.nirvana.ylmc.httplib.myOkhttp;

import java.lang.reflect.Field;

public class HttpServiceDiscover {

    public static void register(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                field.setAccessible(true);
                HttpServiceAnnotation httpServiceAnnotation = field.getAnnotation(HttpServiceAnnotation.class);
                if (httpServiceAnnotation != null) {
                    try {
                        field.set(object, HttpServiceFactory.getInstance().createService(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
