package com.base.support;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class StringJsonSerializer implements ObjectSerializer{
	
	public final static StringJsonSerializer instance = new StringJsonSerializer();

	@Override
	public void write(JSONSerializer serializer, Object object,
			Object fieldName, Type fieldType, int features) throws IOException {
		SerializeWriter out = serializer.getWriter();
		out.write(object.toString());
	}

}
