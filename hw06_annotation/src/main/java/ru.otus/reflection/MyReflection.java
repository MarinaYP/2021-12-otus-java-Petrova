package ru.otus.reflection;


public class MyReflection {
    public static void main(String[] args) {
        TestsRunner.mainTestRunner("ru.otus.reflection.MyPetsFailedTest");
        TestsRunner.mainTestRunner("ru.otus.reflection.MyPetsTest");
        TestsRunner.printResults();
    }
}
