package hao.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
*
* @Author:xionghao
* @Date:2019/4/22 14:04
* @Desc :xionghao
*/
@SpringBootApplication
public class Application {

    public  static void main(String[] args){

        SpringApplication.run(Application.class);
    }
}
