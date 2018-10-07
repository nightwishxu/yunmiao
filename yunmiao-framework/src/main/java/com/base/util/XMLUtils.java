package com.base.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.base.exception.SystemException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLUtils {
	private static XmlMapper mapper = new XmlMapper();

	public static String serialize(Object obj) {
		return serialize(obj, null);
	}

	public static String serialize(Object obj, String propertyName) {
		if ((obj == null) || (((obj instanceof Map)) && (((Map) obj).size() == 0))
				|| (((obj instanceof Collection)) && (((Collection) obj).size() == 0))) {
			return "";
		}

		if (((obj instanceof Collection)) || (!StringUtils.isBlank(propertyName))) {
			if (StringUtils.isBlank(propertyName)) {
				propertyName = "array";
			}

			Map tmpMap = new HashMap();
			tmpMap.put(propertyName, obj);
			obj = tmpMap;
		}

		try {
			String xml = mapper.writeValueAsString(obj);
			return xml.substring(xml.indexOf(">") + 1, xml.lastIndexOf("</"));
		} catch (Exception e) {
			throw new SystemException("XML序列化结果异常:" + e.getMessage());
		}
	}

	public static <T> T deserialize(String xmlStr, Class<T> clazz) {
		if (StringUtils.isBlank(xmlStr)) {
			return null;
		}
		try {
			return mapper.readValue(xmlStr.replace("\n", ""), clazz);
		} catch (Exception e) {
			throw new SystemException("XML反序列化结果异常:" + e.getMessage());
		}
	}
}