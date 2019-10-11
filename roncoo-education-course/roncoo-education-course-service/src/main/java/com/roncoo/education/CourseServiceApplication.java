package com.roncoo.education;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @autohor:wangkun
 * @date 2019-05-19-22:49
 * @email:wk20041208@126.com
 */

@EnableFeignClients
@EnableSwagger2Doc
@ServletComponentScan
@SpringCloudApplication
public class CourseServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(CourseServiceApplication.class,args);
    }
}
