package com.imooc.coupon.lombok;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * ClassName: SetterTest
 * Description: TODO
 * Author: Leo
 * Date: 2020/2/29-12:34
 * email 1437665365@qq.com
 */
public class SetterTest {
    @Setter
    private String dog1;
    @Setter(value = AccessLevel.PRIVATE,onParam ={} )
    private String dog2;
}
