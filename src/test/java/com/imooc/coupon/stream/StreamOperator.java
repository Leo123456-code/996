package com.imooc.coupon.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.enums.SkuCategoryEnum;
import com.imooc.coupon.lambda.cart.CartService;
import com.imooc.coupon.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 *  演示流的各种操作
 * created by Leo徐忠春
 * created Time 2020/2/26-20:08
 * email 1437665365@qq.com
 */
public class StreamOperator {
    List<Sku> list;

    @Before
    public void init(){
        list = CartService.getCartSkuList();
    }

    @Test
    public void fifterTest(){
        list.stream()
                //过滤
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                //forEach是终端操作
                .forEach(item->System.out.println(JSON.toJSONString(item,true)));
    }

    @Test
    public void mapTest(){
        list.stream()
                //map,将一个集合元素转化为另一个元素对象
        .map(Sku::getSkuPrice)
                //打印
        .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    //flatMap 将一个对象转换为另一个流
    @Test
    public void flatMapTest(){
        list.stream()
                //将商品切分转换为一个流
        .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    //中间操作(无状态的中间操作),peek对流中数据进行遍历操作，与forEach类似,但不会销毁流元素
    @Test
    public void peekTest(){
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    //中间操作(有状态的中间操作),排序，对流中元素进行排序
    @Test
    public void sortedTest() {
        list.stream()
                //从大到小排列
                .sorted(Comparator.comparing(Sku::getSkuPrice).reversed())
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
        System.out.println("---------------------------------------------------------------------");
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }



    //中间操作(有状态的中间操作),去重
    @Test
    public void distinctTest() {
        list.stream()
                .peek(sku -> sku.getSkuCategory())
                .distinct().forEach(x->System.out.println(JSON.toJSONString(x,true)));
        System.out.println("------------------------------------");
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct().forEach(x->System.out.println(JSON.toJSONString(x,true)));
        System.out.println("-------------------------------------------------------------------------");
        list.stream()
                .map(sku -> sku.getSkuName())
                .distinct().forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    //中间操作(有状态的中间操作),跳过
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    //中间操作(有状态的中间操作),阶段前几条数据
    @Test
    public void limitTest() {
        list.stream()
                .skip(3)
                .limit(3)
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
        //可做假分页数据，例如每页3条数据,跳过第一页，显示第二页
        System.out.println("--------------------------------------------------");
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(1*3)
                .limit(3)
                .forEach(x->System.out.println(JSON.toJSONString(x,true)));
    }

    /**
     * allMatch使用 :终端操作,短路操作
     * 检测所有元素,所有的元素都符合条件才会返回true
     */
    @Test
    public void allMatchTest() {
        boolean match = list.stream().
                peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }


    /**
     * allMatch使用 :终端操作,短路操作
     * 检测所有元素,如果有一个元素符合条件就会返回true
     * 任何元素匹配返回true
     */
    @Test
    public void anyMatchTest() {
        boolean anyMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(anyMatch);
    }

    /**
     * allMatch使用 :终端操作,短路操作
     * 检测所有元素,所有的元素都不匹配返回true
     */
    @Test
    public void noneMatchTest() {
        boolean noneMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()+":"+sku.getTotalPrice()))
                .noneMatch(sku -> sku.getTotalPrice() > 100000);
        System.out.println(noneMatch);
    }

    /**
     * findFirst使用：短路操作
     * 找到第一个
     *
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> first = list.stream().findFirst();
        System.out.println("找到第一个:"+JSON.toJSONString(first.get(),true));

    }

    /**
     * findAny使用：短路操作
     * 找到任何一个
     * 在并行上findAny要快
     *
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> any = list.stream().findAny();
        System.out.println("找到任何一个:"+JSON.toJSONString(any.get(),true));
    }

    /**
     * max使用：
     * 找到最大值
     *
     */
    @Test
    public void maxTest() {
        OptionalDouble max = list.stream().mapToDouble(Sku::getTotalPrice)
                .max();
        System.out.println(max);
    }

    /**
     * min使用：
     * 找到最小值
     *
     */
    @Test
    public void minTest() {
        OptionalDouble min = list.stream().mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(min);
    }

    /**
     * count使用：
     * 获取元素总数
     *
     */
    @Test
    public void countTest() {
        long count = list.stream().count();
        System.out.println(count);
        System.out.println("-------------------");
        count = list.stream().mapToDouble(Sku::getTotalPrice).count();
        System.out.println(count);

    }
}
