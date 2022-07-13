package com.example.java.proxy.cgl;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyClient {

    public void run(String name) {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            final TargetObject targetObject = new TargetObject();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Before Proxy");
                Object invoke = method.invoke(targetObject, args);
                System.out.println("After Proxy");
                return invoke;
            }
        };

        TargetObject targetObject = (TargetObject) Enhancer.create(TargetObject.class, methodInterceptor);
        targetObject.someMethod(name);
    }

    public static void main(String[] args) {
        CglibProxyClient client = new CglibProxyClient();
        client.run("Shin");
    }

}
