package com.imooc.coupon.file.service;

import com.google.common.base.Function;

import java.util.function.Consumer;

/**
 * created by Leo徐忠春
 * created Time 2020/2/25-21:23
 * email 1437665365@qq.com
 */
public class StaticClass {

    public static void main(String[] args) {
        //指向静态方法引用  目标引用：：方法名
        //(args)-> ClassName.staticMethod(args);
        //ClassName::staticMethod;
        Consumer<String> consumer = (String number) -> Integer.parseInt(number);
        //简单写法
        Consumer<String> consumer1 = Integer::parseInt;
        //指向任意类型实例方法的方法引用
        //(args)-> ClassName.instanceMethod(args);
        //ClassName::instanceMethod;
        Consumer<String> consumer2=(String str)->str.length();
        //简单写法
        Consumer<String> consumer3 = String::length;
        //指向现有对象的实例方法的方法引用
        //(args)->object.instanceMethod;
       //Object::instanceMethod;


    }
}
