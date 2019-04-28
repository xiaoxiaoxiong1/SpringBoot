package hao.xiong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


@Component
public class MyJob {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SendMailService sendMailService;

    //0 0 12,18 * * *


    private ReentrantLock lock = new ReentrantLock();

  //  @Scheduled(cron = "0 0 12,18 * * *")
    public void runMyjob() {

        try {
            if (lock.tryLock()) {
                MailBean mailBean = new MailBean();
                mailBean.setContent("<font color='red' size='20'>媳妇儿:</font><br> &nbsp;&nbsp;&nbsp;&nbsp;走，吃饭饭啦^_^");
                mailBean.setFrom("xionghao@banksteel.com");
                mailBean.setSubject("每日提醒");
                /**
                 *
                 mailBean.setRecipient(new String[]{"1106382564@qq.com","1392348036@qq.com"});
                 */
                mailBean.setRecipient(new String[]{"1392348036@qq.com"});
                logger.info("发送email{}", mailBean);
                sendMailService.sendHTMLMail(mailBean);
                logger.info("发送email成功...");
            }


        } finally {
            lock.unlock();
        }


    }
}
