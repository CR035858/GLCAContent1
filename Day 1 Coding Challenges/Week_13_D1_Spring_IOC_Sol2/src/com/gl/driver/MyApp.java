package com.gl.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.service.CustomFoods;

public class MyApp {

	public static void main(String[] args) {
	
		List<String> finalOrder = new ArrayList<>();
		
		// 1. Spring Configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. create starters bean and add the choice to final order list
		CustomFoods orderFood = context.getBean("starters", CustomFoods.class);		
		finalOrder.add(orderFood.getFood());
		
		// 3. create main course bean and add choice to final order list 
		orderFood = context.getBean("mainCourse", CustomFoods.class);
		finalOrder.add(orderFood.getFood());
		
		// 4. create desert bean and add choice to final order list
		orderFood = context.getBean("desert", CustomFoods.class);
		finalOrder.add(orderFood.getFood());
		
		// 5. Repeat the order to the customer from the list
		System.out.println("\n\nFinal Order is:\n-----------------------------");
		for(String item: finalOrder) {
			System.out.println(item);
		}
		context.close();
	}
}
