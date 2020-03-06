package com.imooc.coupon.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之前的文件拷贝功能
 * created by Leo徐忠春
 * created Time 2020/2/27-14:31
 * email 1437665365@qq.com
 */
public class FileCopyTest {
    @Test
    public void copyFile(){
        //1.创建输入/输出流
        //2.执行文件拷贝,读取文件内容,写入到另一个文件中
        //3.关闭文件流资源

        //定义输入路径和输出路径
        String originalUrl = "lib/FileCopyTest.java";
        String targetUrl = "TargetTest/TargetTest.txt";

        //声明文件输入流，文件输出流
        FileInputStream originalFileInputStream = null;
        FileOutputStream targetFileOutputStream = null;

        try {
            //实例化文件流对象
            originalFileInputStream = new FileInputStream(originalUrl);
            targetFileOutputStream = new FileOutputStream(targetUrl);

            //读取的字节信息
            int content;
            //迭代,读取/写入字节
            while ((content = originalFileInputStream.read()) != -1){
                targetFileOutputStream.write(content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭输出流
            if(targetFileOutputStream != null){
                try {
                    targetFileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭输入流
            if(originalFileInputStream != null){
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
