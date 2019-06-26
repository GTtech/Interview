package org.gttech.interview.service;

import java.util.List;
import java.util.Map;

import org.gttech.interview.entity.TCity;

/**
 * 
 * Copyright: Copyright (c) 2019
 * 
 * @ClassName: TCityService.java
 * @Description:
 *
 * @author: gttech
 * @date: Jun 26, 2019 10:47:52 PM
 */
public interface TCityService {

	/**
	 * 
	 * @Title: getAll
	 * @Description: 获取城市列表
	 *
	 * @author: gttech
	 * @date: Jun 26, 2019 10:48:05 PM
	 * 
	 * @return
	 */
	List<TCity> getAll();

	/**
	 * 
	 * @Title: getWeather
	 * @Description: 获取城市天气
	 *
	 * @author: gttech
	 * @date: Jun 26, 2019 10:47:44 PM
	 * 
	 * @param name
	 * @return
	 */
	Map<String, String> getWeather(String name);
}
