package com.roncoo.education.system.feign;

import com.roncoo.education.system.common.interfaces.BossSys;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @autohor:wangkun
 * @date 2019-05-18-2:02
 * @email:wk20041208@126.com
 */
@FeignClient(value = "roncoo-education-system-service")
public interface IBossSys extends BossSys {
}
