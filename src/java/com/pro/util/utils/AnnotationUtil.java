package com.pro.util.utils;

import com.pro.util.annotation.Controller;
import com.pro.util.annotation.RequestMapping;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnnotationUtil {

    private static String packageName;

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String packageName) {
        AnnotationUtil.packageName = packageName;
    }



    public static List<Class<?>> getControllers(String packageName) {
        List<Class<?>> controllers = null;
        if (controllers == null) {
            controllers = new ArrayList<>();
            List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(packageName);
            if (clsList != null && clsList.size() > 0) {
                for (Class<?> cls : clsList) {
                    if (cls.getAnnotation(Controller.class) != null) {
                        Map<Class<?>, Object> map = new HashMap<>();
                        controllers.add(cls);
                    }
                }
            }
        }
        return controllers;
    }

    public static String getRequestValue(List<Class<?>> clsList){
        String value = null;
        for (Class<?> cls : clsList) {
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                if (annotation != null) {
                    value = annotation.value();//找到RequestMapping的注入value值
                }
            }
        }
        return value;
    }

}