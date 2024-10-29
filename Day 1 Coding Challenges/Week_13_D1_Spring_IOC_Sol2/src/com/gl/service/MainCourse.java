package com.gl.service;

import java.util.Scanner;
import java.util.TreeMap;

public class MainCourse implements CustomFoods {

	Scanner sc = new Scanner(System.in);

	TreeMap<Integer, String> mainCourse = new TreeMap<Integer, String>();

	{
		mainCourse.put(201, "veg Thali");
		mainCourse.put(202, "Non-veg Thali");
		mainCourse.put(203, "Chicken Binryani");

	}

	@Override
	public String getFood() {

		System.out.println("Pick one main course\n"+mainCourse);
		int choice = sc.nextInt();

		if(choice>=mainCourse.firstKey() && choice<=mainCourse.lastKey()) {
			return mainCourse.get(choice);
		}
		return "invalid data";
	}
}
