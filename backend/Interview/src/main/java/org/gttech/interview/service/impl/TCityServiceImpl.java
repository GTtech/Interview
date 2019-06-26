package org.gttech.interview.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gttech.interview.entity.TCity;
import org.gttech.interview.mapper.TCityMapper;
import org.gttech.interview.service.TCityService;
import org.gttech.interview.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * Copyright: Copyright (c) 2019
 * 
 * @ClassName: TCityServiceImpl.java
 * @Description:
 *
 * @author: gttech
 * @date: Jun 26, 2019 10:48:48 PM
 */
@Service
public class TCityServiceImpl implements TCityService {

	@Autowired
	private TCityMapper tCityMapper;

	@Override
	public List<TCity> getAll() {
		return tCityMapper.selectAll();
	}

	@Override
	public Map<String, String> getWeather(String name) {
		StringBuffer strb = new StringBuffer();
		strb.append("https://way.jd.com/he/freeweather?city=").append(name)
				.append("&appkey=6241f7800c6c3a7413668dfc7064a3fc");
		String resultStr = NetUtil.httpRequest(strb.toString(), "GET", null, null, null);
		if (resultStr != null) {
			JSONObject resultjson = JSONObject.parseObject(resultStr);
			if (resultjson != null) {
				String code = resultjson.getString("code");
				if (code.equals("10000")) {
					JSONArray tmparray = resultjson.getJSONObject("result").getJSONArray("HeWeather5");
					if (tmparray.size() > 0) {
						JSONObject tmpIter = tmparray.getJSONObject(0);
						String updateTime = tmpIter.getJSONObject("basic").getJSONObject("update").getString("loc");
						String weather = tmpIter.getJSONObject("now").getJSONObject("cond").getString("txt");
						String temperature = tmpIter.getJSONObject("now").getString("tmp");
						String wind = tmpIter.getJSONObject("now").getJSONObject("wind").getString("spd");
						Map<String, String> result = new HashMap<String, String>();
						result.put("updateTime", updateTime);
						result.put("weather", weather);
						result.put("temperature", temperature);
						result.put("wind", wind);
						return result;
					}
				}
			}
		}

		return null;
	}

}
