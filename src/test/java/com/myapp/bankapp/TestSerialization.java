package com.myapp.bankapp;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.bankapp.model.Account;
import com.myapp.bankapp.model.Client;
import com.myapp.bankapp.service.BankService;
import com.myapp.bankapp.service.Gender;
import com.myapp.bankapp.service.SavingAccount;

public class TestSerialization {
	@Resource
	static private BankService bankService;
	private static ApplicationContext context;
	static private Client customer1, customer2;
	static private Account acc1;

	

	@Test
	public void testSerialization() {
		context = new ClassPathXmlApplicationContext("file:resources/application-context.xml");
		BankService bankService = (BankService) context.getBean("bankService");
		acc1 = new SavingAccount(1500);
		customer1 = new Client("Jan", Gender.MALE, "jan@wp.pl", "888-888-888", "Warsaw");
		bankService.addAccount(customer1, acc1);
		bankService.setActiveAccount(customer1, acc1);		
		bankService.saveClient(customer1);		
		customer2 = bankService.loadClient();
		bankService.setActiveAccount(customer2, acc1);
		assertEquals(customer1, customer2);
	}
}
