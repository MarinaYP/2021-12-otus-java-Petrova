package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflection {
    public static void main(String[] args) {
        runTests("ru.otus.reflection.MyCats", "Murzik", 'F', 1, 3, "funny", 2);
        runTests("ru.otus.reflection.MyDogs", "Ezhi", 'F', 2, 4, "crazy", 4);
        runTests("ru.otus.reflection.MyCats", "Nora", 'F', 5, 5, "lazy", 6);
        runTests("ru.otus.retention.MyPets", "Other", 'M', 10, 120, "other", 100);
        runTests("ru.otus.reflection.MyCats", "Graf", 'M', 9, 5, "important", 6);

        printResults();

    }

    private static void printResults(){
        System.out.println("--------------------------------");
        System.out.println("All tests: "+ allTests);
        System.out.println("Failed tests: "+ failedTests);
        System.out.println("Passed tests: "+ (allTests - failedTests));
    }

    private static void runTests(String className, String name, char sex, int age, int weight, String character, int newWeight){
        try
        {   allTests ++;
            Object object = createObject(className,name, sex, age, weight, character );
            doTest(className, object, newWeight);
        }
        catch(Exception ex) {
            failedTests++;
            System.out.println("\nОШИБКА в тесте класса: " + ex.getMessage());}
    }

    private static Object createObject(String className, String name, char sex, int age, int weight, String character)
            throws Exception{
        Class<?> clazz = Class.forName(className);
        System.out.println("\nClass Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, char.class, int.class, int.class, String.class);
        System.out.println("One constructor="+constructor);
        return constructor.newInstance(name, sex, age, weight, character);
    }

    private static void doTest(String className, Object object, int newWeight) throws Exception{
       Method methodBefore = null;
       Method methodTest = null;
       Method methodAfter = null;
        Class<?> clazz = Class.forName(className);
        /*System.out.println("Class Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());


        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, char.class, int.class, int.class, String.class);
        System.out.println("One constructor="+constructor.toString());
        Object object = constructor.newInstance("Murzik", 'f', 5, 3, "funny");*/

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            Annotation annotationBefore = method.getDeclaredAnnotation(Before.class);
            if (annotationBefore != null) {methodBefore = method;
            System.out.println("MethodBefore="+methodBefore);}

            Annotation annotationTest = method.getDeclaredAnnotation(Test.class);
            if (annotationTest != null) {methodTest = method;
                System.out.println("MethodTest="+methodTest);}

            Annotation annotationAfter = method.getDeclaredAnnotation(After.class);
            if (annotationAfter != null) {methodAfter = method;
                System.out.println("MethodAfter="+methodAfter);}
        }
        methodBefore.invoke(object);
        methodTest.invoke(object, newWeight);
        methodAfter.invoke(object);
    }
    private static int allTests = 0;
    private static int failedTests = 0;
}
