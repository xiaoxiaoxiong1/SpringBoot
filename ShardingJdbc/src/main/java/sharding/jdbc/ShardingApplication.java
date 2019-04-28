package sharding.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Created by Administrator on 2019/3/2.
 * @DESC
 * @DATE 02
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "sharding.jdbc.dbconf.mapper")
public class ShardingApplication {



    public static void main(String args[]){
        System.setProperty("spring.profiles.active","dev");
        SpringApplication.run(ShardingApplication.class,args);
    }
}
