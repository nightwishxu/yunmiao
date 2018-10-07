package com.base.support;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class ObjectJsonSerializer implements ObjectSerializer{
	
	public final static ObjectJsonSerializer instance = new ObjectJsonSerializer();

	@Override
	public void write(JSONSerializer serializer, Object object,
			Object fieldName, Type fieldType, int features) throws IOException {
		SerializeWriter out = serializer.getWriter();
		if (object.getClass().equals(String.class)){
			out.writeString(object.toString());
		}else {
			out.write(object.toString());
		}
	}

}
