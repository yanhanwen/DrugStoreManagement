package com.dsm.model.dao;

import java.util.List;

public interface IDao<T>
{
	/**
	 * 执行：insert、delete、update操作
	 * 
	 * @param sql
	 * @param args
	 * @return 主键值
	 */
	public String update(String sql, Object... args);

	/**
	 * 返回查到的一个对象
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T getSingleObject(String sql, Object... args);

	/**
	 * 返回一组对象
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object... args);

	/**
	 * 返回查到的一个字段
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object getSingleValue(String sql, Object... args);

	/**
	 * 添加一个对象到数据库
	 * 
	 * @param obj
	 */
	public void addObject(Object obj);

	/**
	 * 通过主键从数据库删除一个对象
	 * 
	 * @param key
	 */
	public void deleteObjectByKey(Object key);
}