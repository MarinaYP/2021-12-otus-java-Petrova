package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//"Запускалка" теста
public class TestsRunner {
    public static void mainTestRunner(String className) {
      try {
          runTests(className);
      }
      catch (Exception ex){System.out.println(ex.getCause().getMessage());}
    }

    public static void printResults(){
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("All tests: "+ allTests);
        System.out.println("Failed tests: "+ failedTests);
        System.out.println("Passed tests: "+ (allTests - failedTests));
    }

    private static void runTests(String className) throws Exception{
            Class<?> clazz = findClass(className);
            List<Method> methodsBefore = findMethods(clazz, Before.class);
            List<Method> methodsTest = findMethods(clazz, Test.class);
            List<Method> methodsAfter = findMethods(clazz, After.class);
            for(Method method:methodsTest) {
                Object object = createObject(clazz);
                try
                {
                    allTests ++;
                    doMethods(object, methodsBefore);
                    method.invoke(object);
                    doMethods(object, methodsAfter);
                }
                catch(Exception ex) {
                    failedTests++;
                    System.out.println("\nОШИБКА в тесте класса: " + ex.getCause().getMessage());}
            }

        }

    //Печать методов
    private static void printMethods(List<Method> methods) {
        System.out.println("\nMethods are:");
        for (Method method:methods){ System.out.println(method); }
    }

    //Поиск нужного класса
    private static Class<?> findClass(String className) throws ClassNotFoundException
    {
        Class<?> clazz = Class.forName(className);
        System.out.println("\nClass Name:" + clazz.getSimpleName());
        System.out.println("canonicalName:" + clazz.getCanonicalName());
        return clazz;
    }
    //Общий поиск методов
    private static List<Method> findMethods(Class<?> clazz, Class<? extends Annotation> annClass){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodsNeed = new ArrayList<>();
        for (Method method:methods){
            Annotation annotation = method.getDeclaredAnnotation(annClass);
            if (annotation != null) {methodsNeed.add(method);}
        }
        return methodsNeed;
    }

    //создание объекта
    private static Object createObject(Class<?> clazz)
            throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println("\nOne constructor=" + constructor);
        return constructor.newInstance();
    }

    //вызов методов
   private static void doMethods(Object object, List<Method> methods) throws Exception {
        for(Method method:methods){
                method.invoke(object);
        }

   }

    private static int allTests = 0;
    private static int failedTests = 0;
}
