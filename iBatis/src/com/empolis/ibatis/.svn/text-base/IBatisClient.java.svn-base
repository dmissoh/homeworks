package com.empolis.ibatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empolis.ibatis.orm.IPersonService;

public class IBatisClient {
	public static void main(String[] args) {
		try {
			System.out.println("IBatisClient started");
			System.out.println(" ");

			// load spring beans
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			System.out.println("Classpath loaded");
			System.out.println(" ");
			IPersonService service = (IPersonService) ctx
					.getBean("personService");
			// getTrade
			int tradeId = 1;
			System.out.println("BEFORE: " + service.getPerson(tradeId));

			// update trade
			service.executeChangeName(tradeId);
			System.out.println("AFTER : " + service.getPerson(tradeId));
			System.out.println(" ");
			System.out.println("Hurry!!!! Its done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}