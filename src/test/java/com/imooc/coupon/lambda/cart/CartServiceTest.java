package com.imooc.coupon.lambda.cart;


import com.alibaba.fastjson.JSON;
import com.imooc.coupon.CartApplicationTest;
import com.imooc.coupon.enums.SkuCategoryEnum;
import com.imooc.coupon.lambda.interfaces.SkuPredicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/2/25-13:31
 * email 1437665365@qq.com
 */
@Slf4j
public class CartServiceTest extends CartApplicationTest {
    @Autowired
    private CartService cartService;




    @Test
    public void fifterElectronicsSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //查出所有电子产品
        List<Sku> skus = cartService.fifterElectronicsSkus(cartSkuList);
        log.info("电子产品={}", JSON.toJSONString(skus,true));
    }

    @Test
    public void fifterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //查找书类商品集合
        List<Sku> skus =
                CartService.fifterSkusByCategory(cartSkuList, SkuCategoryEnum.BOOKS);
        log.info("书的集合={}",JSON.toJSONString(skus,true));


    }
    @Test
    public void fifterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        //匿名内部类
        List<Sku> skus1 = cartService.fifterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuCategory().equals(SkuCategoryEnum.SPORTS);
            }
        });

        log.info("运动类={}",JSON.toJSONString(skus1,true));
        cartService.fifterSkus(cartSkuList,sku -> sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)).forEach(System.out::println);
        //查找服装商品集合
        cartService.fifterSkus(cartSkuList,sku -> sku.getSkuPrice()>1000).forEach(System.out::println);
        List<Sku> skus = cartService.fifterSkus(cartSkuList,sku -> sku.getSkuCategory().equals(SkuCategoryEnum.CLOTHING));
        log.info("服装类={}",JSON.toJSONString(skus,true));
        skus = cartService.fifterSkus(cartSkuList, sku -> sku.getTotalPrice() > 2000);
        log.info("商品总额大于2000的={}",JSON.toJSONString(skus,true));
        skus = cartService.fifterSkus(cartSkuList,sku -> sku.getTotalNum() > 1 );
        log.info("商品数量大于1的{}",JSON.toJSONString(skus,true));

    }
}
