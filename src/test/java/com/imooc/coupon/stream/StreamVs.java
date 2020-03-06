package com.imooc.coupon.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.enums.SkuCategoryEnum;
import com.imooc.coupon.lambda.cart.CartService;
import com.imooc.coupon.lambda.cart.Sku;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 对比：原始集合操作与Stream集合操作
 * created by Leo徐忠春
 * created Time 2020/2/26-8:59
 * email 1437665365@qq.com
 */
@Slf4j
public class StreamVs {
    /**
     *1.想看购物车有什么商品
     * 2.图书类商品都给买
     * 3.其余的商品买两件最贵的
     * 4.只需要两件商品的名称和总价
     */

    //以最原始的集合操作实现需求
    @Test
    public void oldCartHandle(){
        //打印所有商品
        List<Sku> cartSkuList = CartService.getCartSkuList();
        for (Sku sku : cartSkuList) {
            log.info("所有商品={}", JSON.toJSONString(sku,true));
        }
        //图书类商品
        List<Sku> bookSkuList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if(sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS)){
                bookSkuList.add(sku);
            }
        }
        //过滤图书类商品
        List<Sku> bookUnCartList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if(!SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory())){
                bookUnCartList.add(sku);
            }
        }
        log.info("非图书类商品={}",JSON.toJSONString(bookUnCartList,true));
        //最贵的两件
        //排序,从大到小
        bookUnCartList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if(sku1.getSkuPrice()>sku2.getSkuPrice()){
                    return -1;
                }else if(sku1.getSkuPrice()<sku2.getSkuPrice()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        log.info("排序的结果={}",JSON.toJSONString(bookUnCartList,true));
        List<Sku> top2SkuList = new ArrayList<>();
        for (int i=0;i<2;i++){
           top2SkuList.add(bookUnCartList.get(i));
       }
        log.info("最贵的两件的商品={}",JSON.toJSONString(top2SkuList,true));
        Double money = 0.0;
        for (Sku sku : top2SkuList) {
            money += sku.getTotalPrice();
        }
        log.info("总价={}",JSON.toJSONString(money));
        //获取两件商品的名称
        List<String> resultNameList = new ArrayList<>();
        for (Sku sku : top2SkuList) {
            resultNameList.add(sku.getSkuName());
        }
        log.info("名字={}",JSON.toJSONString(resultNameList));
    }

    @Test
    public void streamTest(){
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> skuNameList = CartService.getCartSkuList().stream()
                //打印所有商品
                .peek(sku -> System.out.println(sku))
                //过滤图书类的商品
                .filter(sku -> !sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                //排序
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                //选择3件
                .limit(3)
                //计算总价 累加
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                //map集合
                .map(Sku::toString).collect(Collectors.toList());
        log.info("最贵的三件商品名字={}",JSON.toJSONString(skuNameList,true));
    }

    /**
     * 1.所有商品的单价
     * 2.运动类的商品都要买
     * 3.其余商品选三件最便宜的
     * 4.打印所有购买商品的名称和价格,计算总价
     */
    @Test
    public void olderStreamTest(){
        AtomicReference<Double> reference = new AtomicReference<>(Double.valueOf(0.0));
        List<String> list = CartService.getCartSkuList().stream()
                //所有商品名称:单价
                .peek(sku -> System.out.println(sku.getSkuName() + ":" + sku.getSkuPrice()))
                //非运动类
                .filter(sku -> !sku.getSkuCategory().equals(SkuCategoryEnum.SPORTS))
                //排序
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                //选择三件
                .limit(3)
                //计算总价
                .peek(sku -> reference.set(reference.get() + sku.getTotalPrice()))
                //
                .map(Sku::toString).distinct().peek(s -> System.out.println(reference))
                .collect(Collectors.toList());
        log.info("最便宜的三件商品={}",JSON.toJSONString(list,true));
    }
    @Test
    public void olderCartList(){
        List<Sku> cartSkuList = CartService.getCartSkuList();
        Map<String, String> map = new HashMap<>();
        List<Sku> countCartList = new ArrayList<>();
        int count = 0;
        for (Sku sku : cartSkuList) {
            count+=1;
            log.info("购物车所有商品的名称,单价={},{}",JSON.toJSONString(sku.getSkuName()),
                    JSON.toJSONString(sku.getSkuPrice()));
        }
        System.out.println("商品种类数:"+count+"种商品");
        //运动类商品
        List<Sku> sportList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if(sku.getSkuCategory().equals(SkuCategoryEnum.SPORTS)){
                sportList.add(sku);
            }
        }

        log.info("此时加入购物车的商品={}",JSON.toJSONString(sportList));
        List<Sku> sportUnList = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if(!sku.getSkuCategory().equals(SkuCategoryEnum.SPORTS)){
               sportUnList.add(sku);
            }
        }
        //排序.
        //从小到大
        sportUnList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku sku1, Sku sku2) {
                if(sku1.getSkuPrice()<sku2.getSkuPrice()){
                    return -1;
                }
                return 0;
            }
        });
        log.info("非运动类的商品排序={}",JSON.toJSONString(sportUnList,true));
        //选三件
        List<Sku> top3List = new ArrayList<>();
        for (int i=0;i<3;i++){
            top3List.add(sportUnList.get(i));
        }
        log.info("三件最便宜的商品={}",JSON.toJSONString(top3List,true));
        log.info("最后所有的商品={}",JSON.toJSONString(countCartList,true));
        for (Sku sku : sportList) {
            countCartList.add(sku);
        }
        for (Sku sku : top3List) {
            countCartList.add(sku);
        }
        log.info("最后所有的商品={}",JSON.toJSONString(countCartList,true));
        //打印所有购买商品的名称和价格,计算总价
        Double money = 0.0;
         int zcount = 0;
        for (Sku sku : countCartList) {
            zcount +=sku.getTotalNum();
            money +=sku.getTotalPrice();
        }
        log.info("所有商品明细={}",JSON.toJSONString(countCartList,true));
        System.out.println("总价格:"+money+",总数量:"+zcount);



    }
    //以stream流方式实现
    @Test
    public void newCartHale(){
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> list = CartService.getCartSkuList().stream()
                //打印所有商品信息
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                //过滤所有图书
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                //排序
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                //选出2个
                .limit(2)
                //计算总价 累加
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                //获取商品名称
                .map(sku -> sku.getSkuName()).collect(Collectors.toList());
        ;
        log.info("最贵的两件商品={}",JSON.toJSONString(list,true));
    }

}
