package com.imooc.coupon.lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * ClassName: ConstructorTest
 * Description: TODO
 * Author: Leo
 * Date: 2020/2/29-13:20
 * email 1437665365@qq.com
 */
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor 部分参数注解
@RequiredArgsConstructor
public class ConstructorTest {

    private final String filed2;
    @NonNull
    private String filed3;
    private String filed5;
}
