package org.spring.annotation;

import java.lang.annotation.*;

/**
 * @Created by Administrator on 2018/11/11.
 * @DESC
 * @DATE 11
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnno {
}
