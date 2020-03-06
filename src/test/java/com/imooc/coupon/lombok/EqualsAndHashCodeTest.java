package com.imooc.coupon.lombok;

import lombok.EqualsAndHashCode;

/**
 * ClassName: EqualsAndHashCodeTest
 * Description: TODO
 * Author: Leo
 * Date: 2020/2/29-12:38
 * email 1437665365@qq.com
 */
//exclude 是剔除意思
@EqualsAndHashCode(exclude = "dog2")
public class EqualsAndHashCodeTest {
    private String dog1;
    private String dog2;
}
