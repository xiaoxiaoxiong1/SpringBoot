package org.spring.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface Mycomponent {
}
