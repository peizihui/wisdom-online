package com.roncoo.education.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @autohor:wangkun
 * @date 2019-04-22-13:34
 * @email:wk20041208@126.com
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerEurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerEurekaApplication.class,args);

    }
}
