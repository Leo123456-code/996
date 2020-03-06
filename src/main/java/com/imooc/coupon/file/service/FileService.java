package com.imooc.coupon.file.service;

import com.imooc.coupon.file.service.interfaces.FileConsumer;

import java.io.*;

/**
 * 文件服务类
 * created by Leo徐忠春
 * created Time 2020/2/25-15:26
 * email 1437665365@qq.com
 */
public class FileService {

    public void fileHandle(String url,FileConsumer fileConsumer) throws IOException {
        //创建文件读取流
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(url)));
        //定义行变量和内容
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        //循环读取文件内容
        while ((line = bufferedReader.readLine() )!=null){
            stringBuilder.append(line+"\n");
        }
        //调用函数式接口方法,将文件内容传递给lambda表达式,实现业务逻辑
        fileConsumer.fileHandler(stringBuilder.toString());
    }
}
