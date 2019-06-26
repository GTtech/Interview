package org.gttech.interview.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gttech.interview.base.Result;
import org.gttech.interview.entity.TCity;
import org.gttech.interview.service.TCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhongyu.wang
 * @version 2018年7月5日
 * @ClassName 类名称
 * @Description 类描述
 */
@RestController
@RequestMapping("/tcity")
@Api("城市相关api")
public class TCityController {

	@Autowired
	private TCityService tCityService;

	@ApiOperation("查询所有")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Result<List<TCity>> getAll(HttpServletRequest request) {
		List<TCity> tCityList = tCityService.getAll();
		Result<List<TCity>> result = new Result<List<TCity>>();
		if (tCityList != null) {
			result.setCode(Result.ResponseCode.SUCCESS);
			result.setMsg("查询成功");
			result.setObject(tCityList);
		} else {
			result.setCode(Result.ResponseCode.ERROR);
			result.setMsg("查询失败");
		}
		return result;
	}

	@ApiOperation("查询天气")
	@RequestMapping(value = "/getWeather", method = RequestMethod.GET)
	public Result<Map<String, String>> getWeather(HttpServletRequest request, String name) {
		Map<String, String> weather = tCityService.getWeather(name);
		Result<Map<String, String>> result = new Result<Map<String, String>>();
		if (weather != null) {
			result.setCode(Result.ResponseCode.SUCCESS);
			result.setMsg("查询成功");
			result.setObject(weather);
		} else {
			result.setCode(Result.ResponseCode.ERROR);
			result.setMsg("查询失败");
		}
		return result;
	}
}
