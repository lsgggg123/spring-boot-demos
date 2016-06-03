package com.lsgggg123.springboot.quartz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public class DateTask2 {

	private static final Logger logger = LoggerFactory.getLogger(DateTask2.class);

	public void run(Object obj) {
		logger.info("task2 --- start");
		System.out.println("2" + new Date());
		logger.info("task2 --- end");

		System.out.println();
		System.out.println();
	}

}
