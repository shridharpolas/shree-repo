package com.wiley.beginning.spring.ch2.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfiguration {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Ch2BeanConfiguration.class);

		/** 
		 * The method name is accepted as the bean name by default.
		 * Hence, the first argument in the getBean method just below is the 
		 * name of the method that getting passed to get the bean.
		 * 
		 * By default, each bean has a single instance, which is called singleton scope.
		 */
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
		accountService.transferMoney(1, 2, 5.0);
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}
}
