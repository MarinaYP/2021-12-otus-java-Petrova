package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflection {
    public static void main(String[] args) throws Exception{
        runTests("ru.otus.reflection.MyCats");
       // runTests("ru.otus.retention.MyPets");
        runTests("ru.otus.reflection.MyDogs");
    }

    private static void runTests(String className) throws Exception{
        try
        { oneTest(className);}
        catch(Exception ex) {System.out.println(ex.getMessage());}
    }



    private static void oneTest(String className) throws Exception{
       Method methodBefore = null;
       Method methodTest = null;
       Method methodAfter = null;
        Class<?> clazz = Class.forName(className);
        System.out.println("Class Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());
        //System.out.println("Class="+ clazz.getClass().toString());


        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, char.class, int.class, int.class, String.class);
        System.out.println("One constructor="+constructor.toString());
        Object object = constructor.newInstance("Murzik", 'f', 5, 3, "funny");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            //Annotation[] annotations = method.getDeclaredAnnotations();
            Annotation annotationBefore = method.getDeclaredAnnotation(Before.class);
            if (annotationBefore != null) {methodBefore = method;
            System.out.println("MethodBefore="+methodBefore.toString());}

            Annotation annotationTest = method.getDeclaredAnnotation(Test.class);
            if (annotationTest != null) {methodTest = method;
                System.out.println("MethodTest="+methodTest.toString());}

            Annotation annotationAfter = method.getDeclaredAnnotation(After.class);
            if (annotationAfter != null) {methodAfter = method;
                System.out.println("MethodAfter="+methodAfter.toString());}
            //System.out.println("Method: "+ method.toString() + ", Annotations:" + Arrays.toString(annotations));
        }
        //System.out.println("MethodBefore="+methodBefore.toString());
        //System.out.println("MethodTest="+methodTest.toString());
        //System.out.println("MethodAfter="+methodAfter.toString());
        methodBefore.invoke(object);
        methodTest.invoke(object, 5);
        methodAfter.invoke(object);
    }
}
