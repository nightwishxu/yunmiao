package com.base.support;

import com.base.dao.model.Result;
import springfox.documentation.spring.web.json.Json;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.base.api.swagger.SwaggerJsonSerializer;

public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter{

	public FastJsonHttpMessageConverterEx() {
        super();
        this.getFastJsonConfig().getSerializeConfig().put(Json.class, SwaggerJsonSerializer.instance);
        this.getFastJsonConfig().getSerializeConfig().put(String.class, StringJsonSerializer.instance);
    }

}
