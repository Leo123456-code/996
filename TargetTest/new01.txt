package com.imooc.coupon.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基于JD7之后,实现正确关闭流资源方法
 * try - with - resource
 * try(在try小括号里定义资源),不用自定义关闭资源
 * created by Leo徐忠春
 * created Time 2020/2/27-15:02
 * email 1437665365@qq.com
 */
public class NewFileCopyTest {

    @Test
    public void copyFile(){
        //先定义输入/输出对象
        String originalUrl = "lib/NewFileCopyTest.java";
        String targetUrl = "TargetTest/new01.txt";

        //初始化输入/输出流对象
        try(
                FileInputStream originalFileInputStream =
                        new FileInputStream(originalUrl);
                FileOutputStream targetFileOutputStream =
                        new FileOutputStream(targetUrl);

                ) {
            int content;
            while ((content = originalFileInputStream.read())!= -1){
                targetFileOutputStream.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
