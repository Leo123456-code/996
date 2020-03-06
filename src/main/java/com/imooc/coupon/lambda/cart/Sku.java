package com.imooc.coupon.lambda.cart;

import lombok.Data;

/**
 * 下单商品信息对象
 * created by Leo徐忠春
 * created Time 2020/2/25-12:45
 * email 1437665365@qq.com
 */
@Data
public class Sku {
    //编号
    private Integer skuId;
    //名称
    private String skuName;
    //单价
    private Double skuPrice;
    //购买个数
    private Integer totalNum;
    //总价
    private Double totalPrice;
    //商品类型
    private Enum skuCategory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }

    public Sku() {
    }


}
