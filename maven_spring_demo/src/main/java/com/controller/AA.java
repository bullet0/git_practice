package com.controller;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AA {
	
	private int a;
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	@Test
	public void a(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application-config.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		jdbcTemplate.update("INSERT INTO `aaa`.`dictionary` ( `dict_name`, `dict_value`) VALUES( '88888撒打算', '8888撒') ; ");
	}
}
