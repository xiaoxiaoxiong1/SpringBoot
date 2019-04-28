package hao.xiong.controller;

import hao.xiong.MailBean;
import hao.xiong.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xionghao
 * @date ：Created in 2019/4/24 10:29
 * @description：mvc测试
 * @modified By：
 * @version: 0.0.1$
 */
@RestController
public class MyController {
    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/mail/send")
    public Map sendmail(MailBean mailBean){
        sendMailService.sendSimpleMail(mailBean);
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("code","0000");
        return resultMap;
    }


}
