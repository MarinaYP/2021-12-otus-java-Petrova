package ru.otus.reflection;

import ru.otus.annotations.Before;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflection {
    public static void main(String[] args) throws Exception{
        runTests("ru.otus.reflection.MyCats");
    }

    private static void runTests(String className) throws Exception{
        Class<?> clazz = Class.forName(className);
        System.out.println("Class Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());
        //System.out.println("Class="+ clazz.getClass().toString());


        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, char.class, int.class, int.class, String.class);
        System.out.println("One constructor="+constructor.toString());
        Object object = constructor.newInstance("Murzik", 'f', 5, 3, "funny");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println("Method: "+ method.toString() + ", Annotations:" + Arrays.toString(annotations));
            for (Annotation annotation:annotations){
                ;
            }
        }


        //System.out.println("Methods:" + Arrays.toString(methods));
        //Method[] methods = clazz.getDeclaredMethods();
        //System.out.println(Arrays.toString(methods));
        //System.out.println(Arrays.toString(annotations));
    }
}
