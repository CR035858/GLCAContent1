package com.car.services;

import java.time.LocalDate;

import com.car.interfaces.Car;

public class XUV700 implements Car {

	private String carName = "XUV 700";
	private float length = 5.0f;
	private float width = 1.5f;
	private float height = 2.5f;
	
	private int groundClearence = 210;
	private long finalPrice = 2300000L;
	
	
	@Override
	public String getSpecs() {
		
		return "Car Model\t: "+carName+"\nLxWxH\t\t: "+length+" x "+width+" x "+height+" (m)\nGroundClearence\t: "+groundClearence+" (mm)";
	}

	@Override
	public String getPrice() {
		
		return "Final Price\t: "+finalPrice;
	}

	@Override
	public String deliveryDate() {
		return "Delivery on\t: "+LocalDate.now().plusDays(90)+" (If Ordered Now)";
	}

}
