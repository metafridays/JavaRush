package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private  SomeInterfaceWithMethods s;

    public CustomInvocationHandler(SomeInterfaceWithMethods s) {
        this.s = s;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName() + " in");
        Object o1 = method.invoke(s, objects);
        System.out.println(method.getName() + " out");
        return o1;
    }
}
