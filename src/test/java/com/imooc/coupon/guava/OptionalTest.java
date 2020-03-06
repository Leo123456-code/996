package com.imooc.coupon.guava;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 学习JAVA 中的 Optionnal
 * created by Leo徐忠春
 * created Time 2020/2/27-20:17
 * email 1437665365@qq.com
 */
public class OptionalTest {
    @Test
    public void test() throws Throwable {
        /**
         * 三种创建Optional对象
         */
        //1.创建空的Optional对象
        Optional.empty();
        //2.创建一个不为null的对象
        Optional<String> xzc = Optional.of("xzc");
        //3.使用任意值创建Optional对象
        Optional optional = Optional.ofNullable("xzc");

        /**
         * 判断是否引用缺失的方法（建议不直接使用)
         */
        boolean present = optional.isPresent();
        System.out.println(present);
        /**
         * 当Optional存在时执行方法
         * 类似的方法：map  filter  flatMap
         */
        optional.ifPresent(System.out::println);
        /**
         * 当Optional引用缺失时执行
         */
        optional.orElse("引用缺失");

        /**
         * 自定义引用缺失
         */
        optional.orElseGet(()->{
            return "自定义引用缺失";
        });

        /**
         * 自定义引用缺失手动抛出异常
         */
        optional.orElseThrow(()->{
            throw  new RuntimeException("引用缺失异常");
        });

    }

    public static void stream(List<String> list){
        //会抛出异常
//        list.stream().forEach(System.out::println);
        //防止流空指针异常
       Optional.ofNullable(list).map(List::stream)
               .orElseGet(Stream::empty)
               .forEach(System.out::println);
    }

    public static void main(String[] args) {
        stream(null);
    }
}
