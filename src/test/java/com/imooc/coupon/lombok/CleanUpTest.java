package com.imooc.coupon.lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ClassName: CleanUpTest
 * Description: @CleanUp注解 会生成对资源关闭的代码
 * Author: Leo
 * Date: 2020/2/29-13:27
 * email 1437665365@qq.com
 */
public class CleanUpTest {

    public void copyFile(String in, String out)
            throws Exception {

        @Cleanup FileInputStream fileInputStream =
                new FileInputStream(in);
        @Cleanup FileOutputStream fileOutputStream =
                new FileOutputStream(out);

        int r;

        while ((r = fileInputStream.read()) != -1) {
            fileOutputStream.write(r);
        }


    }

}
