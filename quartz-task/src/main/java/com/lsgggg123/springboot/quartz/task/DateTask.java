package com.lsgggg123.springboot.quartz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public class DateTask {

	private static final Logger logger = LoggerFactory.getLogger(DateTask.class);

	public void run(Object obj) {
		logger.info("task --- start");
		System.out.println(new Date());
		logger.info("task --- end");

		System.out.println();
		System.out.println();
	}

}
