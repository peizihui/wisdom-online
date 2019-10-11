package com.roncoo.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @autohor:wangkun
 * @date 2019-04-26-21:26
 * @email:wk20041208@126.com
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class GatewayApiApplication {
    public static void main(String[] args){
        SpringApplication.run(GatewayApiApplication.class,args);
    }
}
