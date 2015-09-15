package com.unep.wcmc.helper;

import java.lang.reflect.Field;

@SuppressWarnings("all")
public class ReflectionUtils {

    public static String findAttributeName(Class target, Class attributeClazz, String name) {
        String result = null;
        for (Field field : target.getDeclaredFields()) {
            try {
                if (field.getType().equals(attributeClazz)) {
                    return field.getName();
                } else {
                    if (!field.isEnumConstant() && !field.getType().getPackage().getName().startsWith("java")) {
                        if (!"".equals(name)) {
                            name += "." + field.getName();
                        } else {
                            name += field.getName();
                        }
                        result = findAttributeName(field.getType(), attributeClazz, name);
                        if (result != null) {
                            if (!"".equals(name)) {
                                return name + "." + result;
                            } else {
                                return result;
                            }
                        } else {
                            name = "";
                        }
                    }
                }
            } catch (Exception ex) {
                // Nothing to do...
            }
        }
        return result;
    }

}
