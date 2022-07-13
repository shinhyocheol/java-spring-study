package com.example.java.proxy.dynamic;

public class TargetObjectImpl implements TargetObject {

    @Override
    public void someMethod(String msg) {
        System.out.println("Real Subject Do something " + msg);
    }
}
