/**
 * $Id$
 * Copyright(C) 2015-2020 yingu - internet center, All Rights Reserved.
 */
package com.example.starter.mybatis.boot.sample.mapper;

import com.example.starter.mybatis.boot.sample.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author <a href="mailto:lzm8285@163.com">Li Zhongmin</a>
 * @version 1.0 2017年03月19日 19:28:00
 */
@Mapper
public interface CarMapper {

	int insert(Car car);

	Car selectByBrandId(@Param("brandId") Integer brandId);

}
