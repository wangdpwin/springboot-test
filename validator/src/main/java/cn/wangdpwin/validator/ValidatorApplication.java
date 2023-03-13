package cn.wangdpwin.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author wangdongpeng
 * @Date 2023/3/13 18:41
 * @Version 1.0
 */
@SpringBootApplication
public class ValidatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ValidatorApplication.class);
        System.out.println(context.getEnvironment().getProperty("server.port"));
    }
}
