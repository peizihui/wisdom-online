package com.roncoo.education.user.feign;

import com.roncoo.education.user.common.interfaces.BossUser;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @autohor:wangkun
 * @date 2019-04-26-23:02
 * @email:wk20041208@126.com
 */
@FeignClient(value = "roncoo-education-user-service")
public interface IBossUser extends BossUser {
}
