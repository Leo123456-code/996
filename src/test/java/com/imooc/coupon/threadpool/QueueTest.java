package com.imooc.coupon.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * ClassName: QueueTest
 * Description: 队列
 * Author: Leo
 * Date: 2020/2/28-20:38
 * email 1437665365@qq.com
 */
public class QueueTest {
    @Test
    /*
     有界队列，队列容量为10
     基于数组的有界阻塞队列
     */
    public void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        //循环向队列添加元素
        for (int i=0;i<20;i++){
            queue.put(i);
            System.out.println("向队列中添加"+i);
        }
    }

    @Test
    /**
     * 有界/无界队列
     * 基于链表的有界/无界阻塞队列
     */
    public void linkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
//        LinkedBlockingQueue queue = new LinkedBlockingQueue<>(10);
        //循环向队列添加元素
        for(int i=0;i<20;i++){
            queue.put(i);
            System.out.println("向队列中添加"+i);
        }
    }

    /**
     * 同步移交阻塞队列
     * 没有存储元素的能力,缓冲的作用
     * 插入和删除同时执行,不能单独执行
     */
    @Test
    public void synchronousQueue() throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue<Integer>();
        new Thread(()->{
            try {
                //插入值
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("插入成功");
        }).start();
//        //删除值
//        new Thread(()->{
//            try {
//                queue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("删除成功");
//        }).start();

        Thread.sleep(100);//休眠
        System.out.println(queue);
    }
}
