package com.roncoo.education.gateway.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @autohor:wangkun
 * @date 2019-04-26-21:29
 * @email:wk20041208@126.com
 */
@Controller
@CrossOrigin
public class IndexController {
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
