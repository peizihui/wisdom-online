package com.roncoo.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @autohor:wangkun
 * @date 2019-04-27-0:12
 * @email:wk20041208@126.com
 */

@EnableSwagger2
@EnableFeignClients
@ServletComponentScan
@SpringCloudApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
