package com.imooc.coupon.lombok;

import lombok.NonNull;

/**
 * ClassName: NonNull
 * Description: 生成非空的检查
 *
 * Author: Leo
 * Date: 2020/2/29-13:13
 * email 1437665365@qq.com
 */
public class NonNullTest {
    /**
     * 会自动进行非空判断
     * @param filed
     */

    public NonNullTest(@NonNull String filed) {
        System.out.println(filed);
    }
}
