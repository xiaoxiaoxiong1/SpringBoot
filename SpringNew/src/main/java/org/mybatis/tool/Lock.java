package org.mybatis.tool;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Created by Administrator on 2019/2/2.
 * @DESC
 * @DATE 02
 */
public class Lock {

    private static java.util.concurrent.locks.Lock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    private static Condition condition2=lock.newCondition();

    public static void  main(String args[]){
        CyclicBarrierManager cyclicBarrierManager;
        //step1
       /* ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

        java.util.concurrent.locks.Lock readLock= lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        readLock.lock();
        System.out.println("当前读");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int  i=0;
                while (true){
                    i++;
                    System.out.println("当前耗时:"+i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readLock.unlock();
        writeLock.lock();
        System.out.println("写锁");*/





    }


}
