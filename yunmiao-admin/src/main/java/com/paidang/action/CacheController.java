package com.paidang.action;

import com.base.dialect.PaginationSupport;
import com.base.web.annotation.LoginFilter;
import com.paidang.service.CacheService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/8/6 14:53
 * @Description:
 */
@RequestMapping("cache")
@Controller
@LoginFilter
public class CacheController {

    @RequestMapping(value = "/expressList",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object list(){
        return CacheService.expressList;
    }
}
