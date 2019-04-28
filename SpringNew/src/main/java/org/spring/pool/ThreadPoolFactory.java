package org.spring.pool;

import java.util.concurrent.*;

/**
 * @Created by Administrator on 2018/10/10.
 * @DESC
 * @DATE 10
 */
public class ThreadPoolFactory {

    public static  ExecutorService createPool(){
       // ThreadPoolExecutor()
       // Executors.newFixedThreadPool(10);
       return new ThreadPoolExecutor(2,
                3,1,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static  ExecutorService createPool2(){
        // ThreadPoolExecutor()
        // Executors.newFixedThreadPool(10);
        return new ThreadPoolExecutor(5,
                10,1,TimeUnit.SECONDS,
                new SynchronousQueue(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }



}
