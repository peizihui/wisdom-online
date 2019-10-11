package com.roncoo.education;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

/**
 * @autohor:wangkun
 * @date 2019-05-08-0:31
 * @email:wk20041208@126.com
 */

/**
 *
 [HPM] Error occurred while trying to proxy request
 /system/api/website/nav/list from localhost:3000 to http://localhost:5840/#/ (ECONNREFUSED)
 (https://nodejs.org/api/errors.html#errors_common_system_errors)
 */
@EnableSwagger2Doc
@EnableFeignClients
@ServletComponentScan
@SpringCloudApplication
public class SystemServiceApplication {
    public static void main(String[] args){

        SpringApplication.run(SystemServiceApplication.class,args);
    }
}
