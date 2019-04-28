package hao.xiong;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author ：xionghao
 * @date ：Created in 2019/4/24 10:10
 * @description：邮件发送bean
 * @modified By：
 * @version: 0.0.1$
 */

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class MailBean {

    private String[] recipient;

    private String subject;
    /**
     *  邮件内容
     */

    private String content;

    private String from;







}
