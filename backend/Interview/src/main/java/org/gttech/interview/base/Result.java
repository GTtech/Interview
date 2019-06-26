package org.gttech.interview.base;

import lombok.Data;

/**
 * 
 * Copyright: Copyright (c) 2019
 * 
 * @ClassName: Result.java
 * @Description: 自定义返回结果
 *
 * @author: gttech
 * @date: Jun 26, 2019 9:21:29 PM
 */
@Data
public class Result<T> {

	public enum ResponseCode {
		SUCCESS, ERROR;
	}

	private ResponseCode code;
	private String msg;
	private T object;

}
