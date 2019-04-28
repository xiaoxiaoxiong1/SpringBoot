package org.spring.config;

import org.spring.ConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component

public class LoadBean2 implements BeanInterface  {
    private String name="dev";
  
}
