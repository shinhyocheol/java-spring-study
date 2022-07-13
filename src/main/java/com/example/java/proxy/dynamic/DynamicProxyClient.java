package com.example.java.proxy.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyClient {

    TargetObject realObject = (TargetObject) Proxy.newProxyInstance(
            TargetObject.class.getClassLoader(),
            new Class[] {TargetObject.class},
            (InvocationHandler) (proxy, method, args) -> {
                TargetObject targetObject = new TargetObjectImpl();
                System.out.println("Before Proxy");
                Object invoke = method.invoke(targetObject, args);
                System.out.println("After Proxy");

                return invoke;
            });

    public void run(String name){
        realObject.someMethod(name);
    }

    public static void main(String[] args) {
        DynamicProxyClient dynamicProxyClient = new DynamicProxyClient();
        dynamicProxyClient.run("Shin");
    }
}
