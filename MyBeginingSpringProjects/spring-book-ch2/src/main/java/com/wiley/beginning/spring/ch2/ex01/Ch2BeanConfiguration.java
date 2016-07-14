package com.wiley.beginning.spring.ch2.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is the java base configuration in spring.
 * 
 * @author Administrator
 *
 */
@Configuration
public class Ch2BeanConfiguration {

	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());
		return bean;
	}

	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		// Dependencies of accountDao bean will be injected here...
		return bean;
	}
}
