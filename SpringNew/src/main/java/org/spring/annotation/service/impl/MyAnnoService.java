package org.spring.annotation.service.impl;

import org.spring.annotation.MyAnno;
import org.spring.annotation.Mycomponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
@MyAnno
public class MyAnnoService {

    public void test(){
        System.out.println("11111111111111");

    }
}
