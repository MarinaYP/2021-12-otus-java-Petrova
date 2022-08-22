package ru.otus.AOP;

import ru.otus.Annotations.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLogging myClass;

        DemoInvocationHandler(TestLogging myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Annotation annotation = method.getDeclaredAnnotation(Log.class);
            if (annotation != null) {
                System.out.println("executed method:" + method.getName() + ", param:" + Arrays.deepToString(args));
            }

            return method.invoke(myClass, args);
        }

    }
}
