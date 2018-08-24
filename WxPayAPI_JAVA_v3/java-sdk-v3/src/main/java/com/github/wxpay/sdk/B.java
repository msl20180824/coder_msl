package com.github.wxpay.sdk;

import java.lang.reflect.Method;

public class B {

    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("com.github.wxpay.sdk.A");

            System.out.println(aClass.getMethod("aVoid"));

        }catch (Exception e){

        }

    }
}
