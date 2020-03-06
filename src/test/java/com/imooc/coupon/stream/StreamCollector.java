package com.imooc.coupon.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.lambda.cart.CartService;
import com.imooc.coupon.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定义收集器使用
 * created by Leo徐忠春
 * created Time 2020/2/27-13:44
 * email 1437665365@qq.com
 */
public class StreamCollector {
    List<Sku> list;

    @Before
    public void before(){
        list = CartService.getCartSkuList();
    }
    @Test
    public void toList(){

        //收集结果
        List<Sku> skus = list.stream().filter(sku -> sku.getTotalPrice() > 1000)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(skus,true));
    }

    //分组
    //Map<分组条件,结果集合>
    @Test
    public void groupList(){
        Map<Enum, List<Sku>> listMap =
                list.stream().collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(listMap,true));

    }

    //分区
    //Map <true,结果集合> <false,结果集合>
    @Test
    public void partition(){
        Map<Boolean, List<Sku>> listMap = list.stream().collect(Collectors.
                partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JSON.toJSONString(listMap,true));

    }
}
