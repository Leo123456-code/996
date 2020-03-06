package com.imooc.coupon.file.service;


import com.imooc.coupon.CartApplicationTest;
import org.junit.Test;

import java.io.IOException;

/**
 * created by Leo徐忠春
 * created Time 2020/2/25-15:40
 * email 1437665365@qq.com
 */

public class FileServiceTest extends CartApplicationTest {

    @Test
    public void fileHandle() throws IOException {
        //通过lambda表达式,打印文件内容
        FileService service = new FileService();
        service.fileHandle("E:\\WORKPACE\\cart\\src\\test\\java\\com\\imooc\\coupon\\file" +
                "\\service\\FileServiceTest.java",fileContent -> System.out.println(fileContent));

    }
}
