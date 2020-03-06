package com.imooc.coupon.stream;

import org.junit.Test;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的四种构建形式
 * created by Leo徐忠春
 * created Time 2020/2/27-13:09
 * email 1437665365@qq.com
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void StreamFromValue(){
        Stream stream02 = Stream.of(1, 2, 3, 4, 5);
        stream02.forEach(System.out::println);
    }


    /**
     * 由数组直接构建流
     */
    @Test
    public void StreamFromArray(){
        int[] number = {1,2,3,4,5,6,7};
        IntStream stream = Arrays.stream(number);
        stream.forEach(System.out::print);
    }

    /**
     * 通过文件生成流
     */
    @Test
    public void StreamFormFile() throws Exception{
        Stream<String> stream = Files.lines(Paths.get("E:\\WORKPACE\\cart\\src\\test\\java\\com" +
                "\\imooc\\coupon\\stream\\StreamConstructor.java"));
        stream.forEach(System.out::println);
    }

    /**
     * 通过函数生成流
     */
    @Test
    public void streamFormFunction(){
        Stream stream = Stream.iterate(0, n -> n+2);
        stream.limit(200).forEach(System.out::println);
        System.out.println("-------------");
        //生成随机的流
        Stream<Double> stream01 = Stream.generate(Math::random);
        stream01.limit(100).forEach(System.out::println);
    }
}
