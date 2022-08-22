package ru.otus.AOP;

public class Demo {

    public static void main(String[] args) {
        TestLoggingInterface myClass = Ioc.createMyClass();
        myClass.calculation(6);
        myClass.calculation(3, 5);
    }
}
