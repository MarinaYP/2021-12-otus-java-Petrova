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
    static <T> T createMyClass(Object obj) {
        InvocationHandler handler = new DemoInvocationHandler(obj);
        return (T) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                                          obj.getClass().getInterfaces(),
                                          handler);
    }


    static class DemoInvocationHandler implements InvocationHandler {
        private final Object myClass;
        DemoInvocationHandler(Object obj) {
            this.myClass = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Annotation annotation = myClass.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Log.class);
            if (annotation != null) {
                System.out.println("executed method:" + method.getName() + ", param:" + Arrays.deepToString(args));
            }

            return method.invoke(myClass, args);
        }

    }
}
