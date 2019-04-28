package org.spring.retry;

import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Created by Administrator on 2018/10/16.
 * @DESC
 * @DATE 16
 */
@Service
public class MyCircuitBreaker implements  CircuyService{
    /** 10S内如果失败次数超过3次，那么默认进入recovery
     *  以后即使可以成功，在11S内都不可以返回正确案例，直接进入recovery
     *  PS：过了11S，如果没有任何请求，那么会恢复，不在默认进入recovery
     *
     * @param num
     */
    @Override
    @CircuitBreaker(maxAttempts=3,openTimeout=10000,resetTimeout=11000,label="test-CircuitBreaker",include=RuntimeException.class,exclude=Exception.class)
    public  void retry(int num) {
        System.err.print(" 进入断路器方法num="+num);
        if(num>8)return;
        Integer n=null;
        System.err.println(1/n);
    }


    @Recover
    public void recover(NullPointerException exception) {
        System.err.println(" NullPointerException ....");
    }

    @Recover
    public void recover(RuntimeException exception) {
        System.err.println(" RuntimeException ....");
    }

    @Recover
    public void recover(Exception exception) {
        System.err.println(" exception ....");
    }

    @Recover
    public void recover(Throwable throwable) {
        System.err.println(" throwable ....");
    }
    @Recover
    public void recover() {
        System.err.println(" recover ....");
    }
}
