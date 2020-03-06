package com.imooc.coupon.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * ClassName: RunTest
 * Description: 向线程池提交任务
 * Author: Leo
 * Date: 2020/2/29-11:10
 * email 1437665365@qq.com
 */
public class RunTest {

    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //submit提交任务
        Future<Integer> future = threadPool.submit(() -> {
            try {
                //执行任务
                System.out.println("执行任务开始...");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结束...");
            return 5 * 2;
        });
        //阻塞方法,直到任务有返回值，才向下执行
        Integer num = future.get();
        System.out.println("执行结果:"+num);
    }

    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService executorPool = Executors.newCachedThreadPool();
        //execute提交任务,没有返回结果
        executorPool.execute(()->{
            try {
                //执行任务逻辑
                System.out.println("执行任务开始...");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer num = 10;
            System.out.println("执行结果 :"+num);
            System.out.println("执行任务结束...");
        });
        //主线程休眠
        Thread.sleep(100);
    }
}
