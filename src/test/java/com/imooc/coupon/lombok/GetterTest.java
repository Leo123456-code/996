package com.imooc.coupon.lombok;



import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;


/**
 * Lombok是插入式注解
 * 实现原理: javac->生成抽象语法树->插入式注解处理器处理->语法树无变动之后
 * ->生成字节码 ->生成.class文件
 *
 * ClassName: data
 * Description: 为类中属性生成get方法
 * Author: Leo
 * Date: 2020/2/29-11:59
 * email 1437665365@qq.com
 */

public class GetterTest {
    //懒加载开启
    @Getter (lazy =true )
    private final String filed0 = "xzc";
    @Getter(value = AccessLevel.PRIVATE,onMethod ={})
    private String filed1;
    private String filed2;
}
