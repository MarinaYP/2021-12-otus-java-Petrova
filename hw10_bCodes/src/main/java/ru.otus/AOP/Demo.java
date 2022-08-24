package ru.otus.AOP;


public class Demo {

    public static void main(String[] args) {
        TestLoggingInterface obj = new TestLogging();
        TestLoggingInterface myClass = Ioc.createMyClass(obj);
        myClass.calculation(6);
        myClass.calculation(3, 5);
        myClass.calculation(-1, -2, "bubu");
    }
}
