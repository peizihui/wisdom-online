package com.roncoo.education.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @autohor:wangkun
 * @date 2019-04-22-13:27
 * @email:wk20041208@126.com
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ServerConfigApplication {
    public static void main(String[] args){

        SpringApplication.run(ServerConfigApplication.class,args);
    }
}
