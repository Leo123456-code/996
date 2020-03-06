package com.imooc.coupon.lambda.cart;

import com.imooc.coupon.enums.SkuCategoryEnum;
import com.imooc.coupon.lambda.interfaces.SkuPredicate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Leo徐忠春
 * created Time 2020/2/25-12:53
 * email 1437665365@qq.com
 */
@Service
public class CartService {
    /**
     * 加入购物车的商品信息
     */
    private static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
          add(new Sku(654032,"无人机",4999.0,
                  1,4999.0, SkuCategoryEnum.ELECTRONICS));

            add(new Sku(642934, "VR一体机",
                    2299.00, 1,
                    2299.00, SkuCategoryEnum.ELECTRONICS));

            add(new Sku(645321, "纯色衬衫",
                    409.00, 3,
                    1227.00, SkuCategoryEnum.CLOTHING));

            add(new Sku(654327, "牛仔裤",
                    528.00, 1,
                    528.00, SkuCategoryEnum.CLOTHING));

            add(new Sku(675489, "跑步机",
                    2699.00, 1,
                    2699.00, SkuCategoryEnum.SPORTS));

            add(new Sku(644564, "Java编程思想",
                    79.80, 1,
                    79.80, SkuCategoryEnum.BOOKS));

            add(new Sku(678678, "Java核心技术",
                    149.00, 1,
                    149.00, SkuCategoryEnum.BOOKS));

            add(new Sku(697894, "算法",
                    78.20, 1,
                    78.20, SkuCategoryEnum.BOOKS));

            add(new Sku(696968, "TensorFlow进阶指南",
                    85.10, 1,
                    85.10, SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品信息列表
     * @return
     */
    public static List<Sku> getCartSkuList(){
        return cartSkuList;
    }

    /**
     * 找出所有的电子产品列表
     * @param cartSkuList
     * @return
     */
    public static List<Sku> fifterElectronicsSkus(List<Sku> cartSkuList){
        List<Sku> list = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            //如果商品是电子类
            if(SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())){
                list.add(sku);
            }
        }
        return list;
    }

    /**
     * 根据传入的商品类型参数,找出购物车同种商品类型的商品列表
     * @param cartSkuList  商品信息列表
     * @param category   商品类型
     * @return
     */
    public static List<Sku> fifterSkusByCategory(
            List<Sku> cartSkuList,SkuCategoryEnum category){
        List<Sku> list = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if(sku.getSkuCategory().equals(category)){
                list.add(sku);
            }
        }
        return list;
    }

    /**
     * 根据不同的Sku选择标准,对Sku列表进行过滤
     * @param cartSkuList
     * @param predicate
     * @return
     */
    public List<Sku> fifterSkus(
            List<Sku> cartSkuList, SkuPredicate predicate){
        List<Sku> list = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            //根据不同的Sku 判断标准策略,对Sku进行判断
            if(predicate.test(sku)){
                list.add(sku);
            }
        }

        return list;

    }


}
