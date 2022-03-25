package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//"Запускалка" теста
public class TestsRunner {
    public static void mainTestRunner(String className) {
      runTests(className);
    }

    public static void printResults(){
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("All tests: "+ allTests);
        System.out.println("Failed tests: "+ failedTests);
        System.out.println("Passed tests: "+ (allTests - failedTests));
    }

    private static void runTests(String className){
        try
        {   allTests ++;
            Object object = createObject(className);
            doTest(className, object);

        }
        catch(Exception ex) {
            failedTests++;
            System.out.println("\nОШИБКА в тесте класса: " + ex.getMessage());}
    }

    private static Object createObject(String className)
            throws Exception {
        Class<?> clazz = Class.forName(className);
        System.out.println("\nClass Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println("One constructor=" + constructor);
        return constructor.newInstance();
    }

    private static void doTest(String className, Object object) throws Exception{
        Method methodBefore = null;
        Method methodTest = null;
        Method methodAfter = null;
        Class<?> clazz = Class.forName(className);

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
        methodTest.invoke(object);
        methodAfter.invoke(object);
    }
    private static int allTests = 0;
    private static int failedTests = 0;
}
