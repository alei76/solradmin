package com.epweike.service;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuxp
 */
@Service
public abstract class BaseService<T> {

	@Autowired
	protected Mapper<T> mapper;

	public int insert(T record) {
		return mapper.insert(record);
	}

	public int delete(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	public int update(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	public T get(int key) {
		return mapper.selectByPrimaryKey(key);
	}

	public int count(T record) {
		return mapper.selectCount(record);
	}
	
	public List<T> select(T record) {
		return mapper.select(record);
	}

	/**
	 * 单表分页查询
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<T> selectPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// Spring4支持泛型注入
		return mapper.select(null);
	}
}