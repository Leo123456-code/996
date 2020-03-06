package com.imooc.coupon.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * ClassName: IOTest
 * Description: 演示如何使用流(source)与汇(Sink)来对文件进行
 * 常用操作
 * Author: Leo
 * Date: 2020/2/28-14:51
 * email 1437665365@qq.com
 */
public class IOTest {
    @Test
    public void copyFile() throws IOException {
        //创建对应的流与汇
        CharSource charSource = Files.asCharSource(new File(""), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File(""), Charsets.UTF_8);
        /**
         * 拷贝
         */
        charSource.copyTo(charSink);

    }
}
