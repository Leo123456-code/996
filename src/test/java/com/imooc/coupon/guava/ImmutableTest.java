package com.imooc.coupon.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 不可变集合用法
 * created by Leo徐忠春
 * created Time 2020/2/28-8:46
 * email 1437665365@qq.com
 */
public class ImmutableTest {

    public static void test(List<Integer> list){
        //移除第一个元素
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(120);
        list.add(88);
        list.add(879);
        test(list);
        System.out.println(list);
        System.out.println("--------------------上面的集合不安全----------------");
    }

    @Test
    public void Immutable(){
        List<Integer> list = new ArrayList<>();

        list.add(120);
        list.add(88);
        list.add(879);
        /**
         * 构建不可变集合对象的三种方式
         */
        //1.通过已经存在的集合创建
        ImmutableSet<Integer> immutableSet = ImmutableSet.copyOf(list);
        //2.通过初始值,直接创建不可变集合
        ImmutableSet<Integer> set = ImmutableSet.of(1, 2, 3);
        //3.通过builder方式创建
        ImmutableSet<Object> objects = ImmutableSet.builder().add(1).
                addAll(Sets.newHashSet(2, 3, 4)).add(5)
                .build();
        System.out.println(immutableSet);
    }
}
