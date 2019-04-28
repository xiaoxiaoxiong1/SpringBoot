package org.spring.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Created by Administrator on 2018/10/10.
 * @DESC
 * @DATE 10
 */
public class PoolDemo {

    public static void main(String args[]){

        ExecutorService executorService= ThreadPoolFactory.createPool();
        ExecutorService executorService2=ThreadPoolFactory.createPool2();
        /* try {
             System.out.println(future.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }*/
        for(int i=0;i<10;i++)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    executorService2.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000L);

                                System.out.println("sucess");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
    }
}
