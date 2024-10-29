package com.driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.car.interfaces.Car;

public class MahindraMotors {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Car vehicle = context.getBean("xuv700", Car.class);

		System.out.println(vehicle.getSpecs());
		System.out.println(vehicle.getPrice());
		System.out.println(vehicle.deliveryDate());

		System.out.println("\n---------------------------------\n");
		vehicle = context.getBean("xuv300", Car.class);

		System.out.println(vehicle.getSpecs());
		System.out.println(vehicle.getPrice());
		System.out.println(vehicle.deliveryDate());

		System.out.println("\n---------------------------------\n");
		vehicle = context.getBean("thar", Car.class);

		System.out.println(vehicle.getSpecs());
		System.out.println(vehicle.getPrice());
		System.out.println(vehicle.deliveryDate());
	}
}
