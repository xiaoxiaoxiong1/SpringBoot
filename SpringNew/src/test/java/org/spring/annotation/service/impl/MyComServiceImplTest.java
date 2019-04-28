package org.spring.annotation.service.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.MySpringApplication;
import org.spring.annotation.service.MyComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringApplication.class)
@ActiveProfiles("dev")
public class MyComServiceImplTest extends TestCase {

    @Autowired
    private MyComService myComService;

    @Test
    public void doSomething(){
        myComService.doSomething();
    }
}