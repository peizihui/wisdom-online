package com.roncoo.education.gateway.api.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.tools.JSONUtil;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @autohor:wangkun
 * @date 2019-05-04-19:45
 * @email:wk20041208@126.com
 */
public class FilterPost extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;

    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 异常处理
        if (ctx.getResponseStatusCode() != 200) {
            ctx.getResponse().setCharacterEncoding("UTF-8");
            ctx.setResponseBody(JSONUtil.toJSONString(Result.error(99, "服务异常，请重试")));
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
