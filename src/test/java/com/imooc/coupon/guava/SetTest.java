package com.imooc.coupon.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * ClassName: SetTest
 * Description: List/Sets 使用
 * Author: Leo
 * Date: 2020/2/28-13:46
 * email 1437665365@qq.com
 */
public class SetTest {
    /**
     * Sets 工具类的常用方法
     * 并集/交集/差集/分解集合中的所有子集/求两个集合的笛卡尔积
     *
     * Lists 工具类的常用方法
     * 反转/拆分
     */

    private static final Set set1 =  Sets.newHashSet(1,2,3);
    private static final Set set2 =  Sets.newHashSet(4,5,6);
    /**
     * 并集
     */
    @Test
    public void union(){
        Set<Integer> union = Sets.union(set1, set2);
        System.out.println(union);
    }
    /**
     * 交集
     */
    @Test
    public void intersection(){
        Set<Integer> intersection = Sets.intersection(set1, set2);
        System.out.println(intersection);
    }

    /**
     * 差集  ：如果元素属于A 而不属于B
     */
    @Test
    public void difference(){
        Set<Integer> difference = Sets.difference(set1, set2);
        System.out.println(difference);
        //相对差集: 属于A而不属于B，属于B而不属于A
        difference = Sets.symmetricDifference(set1,set2);
        System.out.println(difference);
    }

    /**
     * 将集合拆解为多个子集合
     */
    @Test
    public void powerSet(){
        Set<Set<Integer>> set = Sets.powerSet(set1);
        System.out.println(JSON.toJSONString(set));
        System.out.println(set.size());
    }

    /**
     * 计算两个集合的笛卡尔积
     */
    @Test
    public void cartesianProduct(){
        Set<List<Integer>> sets = Sets.cartesianProduct(set1,set2);
        System.out.println(JSON.toJSONString(sets));
        Set<List<Integer>> product = Sets.cartesianProduct(set2, set1);
        System.out.println(JSON.toJSONString(product));
    }

    /**
     * 按个数拆分集合
     */
    @Test
    public void cartesianProdut(){
        List<Integer> list =
                Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        List<List<Integer>> partition = Lists.partition(list, 3);
        System.out.println(JSON.toJSONString(partition));
    }

    /**
     * 反转
     */
    @Test
    public void reverse(){
        List<Integer> linkedList = Lists.newLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        List<Integer> newList = Lists.reverse(linkedList);
        System.out.println(newList);
    }

}
