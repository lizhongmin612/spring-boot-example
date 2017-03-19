/**
 * $Id$
 * Copyright(C) 2015-2020 yingu - internet center, All Rights Reserved.
 */
package com.example.starter.mybatis.boot.sample;

import com.example.starter.mybatis.boot.sample.domain.Car;
import com.example.starter.mybatis.boot.sample.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:lzm8285@163.com">Li Zhongmin</a>
 * @version 1.0 2017年03月19日 19:02:00
 */
@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Autowired
	private CarMapper carMapper;

	public void run(String... strings) throws Exception {
		Car car = new Car();
		car.setBrandId(3);
		car.setInventory(100);
		carMapper.insert(car);
	}
}
