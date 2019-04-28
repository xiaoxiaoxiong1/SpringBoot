package hao.xiong.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.javafx.binding.StringFormatter;
import hao.xiong.facade.DubboFacade;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ：xionghao
 * @date ：Created in 2019/4/25 15:29
 * @description：Duubo测试接口
 * @modified By：
 * @version: 0.0.1$
 */
@Service(version = "0.0.1")
public class DubboFacadeImpl implements DubboFacade {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String info) {
       return String.format("hello,%s",info);
    }
}
