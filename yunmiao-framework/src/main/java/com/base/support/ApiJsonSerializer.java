package com.base.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.base.des.DES;
import com.base.util.JSONUtils;
import com.base.util.ObjectUtil;

import java.io.IOException;
import java.lang.reflect.Type;

public class ApiJsonSerializer implements ObjectSerializer{
	
	public final static ApiJsonSerializer instance = new ApiJsonSerializer();

	@Override
	public void write(JSONSerializer serializer, Object object,
			Object fieldName, Type fieldType, int features) throws IOException {
		System.out.println("api");
		System.out.println(object.toString());
		SerializeWriter out = serializer.getWriter();
//		out.write(object.toString());
		try {
			out.writeByteArray(new DES().desEncrypt(JSON.toJSONBytes(object)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
