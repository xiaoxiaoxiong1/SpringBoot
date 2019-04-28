package org.spring.retry;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.spring.exception.NotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Created by Administrator on 2018/10/16.
 * @DESC
 * @DATE 16
 */
@Service
@EnableRetry
public class RetryServiceImpl implements RetryService{
    private AtomicInteger num=new AtomicInteger(0);
    Logger logger= org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Override
    @Retryable(include = NotFoundException.class, maxAttempts = 4,backoff=@Backoff(value=2000L))
    public String retry() {
        logger.info("开始次数{}",num.incrementAndGet());
        if(num.intValue()>10){
            return "i am fine";
        }
       throw new NotFoundException("error");
    }

   @Recover
    public String recover(NotFoundException e){
       logger.info("重试次数失败");
       return "everything is OK";
   }
}
