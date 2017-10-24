package com.dsm.model.utils;

import java.lang.reflect.Method;

public class ReflectionTools
{

	// 调用java bean的setterֵ
	public static void setter(Object obj, String attr, Object value)
	{
		try
		{ 
			if (value != null)
			{
				Method method = obj.getClass().getMethod("set" + capitalizeFirstLetter(attr), value.getClass());
				method.invoke(obj, value);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	// 调用java bean的getterֵ
	public static Object getter(Object obj, String attr)
	{
		Object value = null;
		try
		{
			Method method = obj.getClass().getMethod("get" + capitalizeFirstLetter(attr));
			value = method.invoke(obj);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}

	// 首字母大写
	public static String capitalizeFirstLetter(String str)
	{
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
	}
}