package com.imooc.coupon.file.service.interfaces;

/**
 * 文件处理函数式接口
 * created by Leo徐忠春
 * created Time 2020/2/25-15:28
 * email 1437665365@qq.com
 */
@FunctionalInterface
public interface FileConsumer {
    /**
     * 函数式接口抽象方法
     * @param fileContent --文件内容字符串
     */
    void fileHandler(String fileContent);
}
