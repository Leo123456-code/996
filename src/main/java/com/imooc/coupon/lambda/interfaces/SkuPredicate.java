package com.imooc.coupon.lambda.interfaces;

import com.imooc.coupon.lambda.cart.Sku;

/**
 * Sku选择谓词接口
 * created by Leo徐忠春
 * created Time 2020/2/25-13:59
 * email 1437665365@qq.com
 */
public interface SkuPredicate {
    /**
     * 不同的选择标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);

}
