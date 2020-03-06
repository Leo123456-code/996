package com.imooc.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品类型枚举
 * created by Leo徐忠春
 * created Time 2020/2/25-12:55
 * email 1437665365@qq.com
 */
@AllArgsConstructor
@Getter
public enum SkuCategoryEnum {
    CLOTHING(10,"服装类"),
    ELECTRONICS(20,"数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类"),
    ;
    //编号
    private Integer code;
    //名称
    private String name;
}
