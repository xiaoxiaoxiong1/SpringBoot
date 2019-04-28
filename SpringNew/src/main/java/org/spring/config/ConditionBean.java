package org.spring.config;

import org.spring.ConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

/*@Configuration
@Profile("pro") //只有在生产环境在实例化
@Data*/
public class ConditionBean implements BeanInterface {
    private String name="dev";
  
}
