package com.imooc.coupon.lombok;



import lombok.experimental.var;
import lombok.val;

import java.util.ArrayList;

/**
 * ClassName: ValTest
 * Description: Val 注解
 * 弱语言
 * 作用域:本地方法
 * Author: Leo
 * Date: 2020/2/29-12:52
 * email 1437665365@qq.com
 */
public class ValTest {

    public ValTest(){
        val field = "zhangxiaoxi";

        val list = new ArrayList<String>();
        list.add("zhangxiaoxi");
    }
}
