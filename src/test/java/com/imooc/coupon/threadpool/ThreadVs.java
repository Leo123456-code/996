package com.imooc.coupon.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ThreadVs
 * Description: TODO
 * Author: Leo
 * Date: 2020/2/28-15:54
 * email 1437665365@qq.com
 */
public class ThreadVs {
    /**
     * 开启线程池
     * @throws InterruptedException
     */
    @Test
    public void ThreadPoolTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int request = 1;request<= 100;request++){
            threadPool.execute(()->{
                //处理文档逻辑
                System.out.println
                        (Thread.currentThread().getName()+":文档处理开始...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束...");
            });
        }
        //主线程休眠
        Thread.sleep(100);

    }
    @Test
    public void youngHandle()throws Exception{
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int j=0;j<10;j++){
            pool.execute(()->{
                //执行业务逻辑
                for (int request = 1;request<= 100;request++){
                    System.out.println
                            (Thread.currentThread().getName()+":文档处理开始...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("处理完成");
                }
                //主线程休眠
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    //老的处理方式
    @Test
    public void oldHandle() throws InterruptedException {
        /**
         * 使用循环来模拟许多用户请求的场景
         */
        for (int request = 1;request<= 100;request++){
            new Thread(()->{
                System.out.println
                        (Thread.currentThread().getName()+":文档处理开始...");
                try {
                    //将Word转换为PDF格式:处理时长很长的耗时
                    Thread.sleep(10L*30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理完毕...");
            }).start();
        }
        //主线程休眠
        Thread.sleep(10);
    }
}
