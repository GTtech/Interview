package org.gttech.interview.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * Copyright: Copyright (c) 2019
 * 
 * @ClassName: BaseMapper.java
 * @Description: 通用Mapper的基类
 *
 * @author: gttech
 * @date: Jun 26, 2019 9:20:22 PM
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}