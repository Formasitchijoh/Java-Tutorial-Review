package Fundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apple {
 
	//creating a an Apple object 
	
	int weight;
	String color;
	
	public enum Color {RED,GREEN};
	 Color col;
	public Apple(int weight, String color) {
		this.weight = weight ;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public class AppleFancyFormatter implements AppleFormatter {
		public String accept(Apple apple) {
			
			String Xtic = apple.getWeight() > 150 ? "Heavy" : "light";
			return "A " + Xtic + " " + apple.getColor() + " apple";
			
		}
	}
	
	public class AppleSimpleFormatter implements AppleFormatter {
		public String accept(Apple apple) {
			return "An apple of " + apple.getWeight() + "g";
		}
	}
	
	public static void pPApple(List<Apple> inventory, AppleFormatter formatter) {
		
		for(Apple apple : inventory) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
	
	public static void main(String[] args) {
		List<Apple> list = new ArrayList<Apple>(2);
		
	
		Apple apple = new Apple(40, "GREEN");
		Apple app = new Apple(290, "RED");
		
		list.add(apple);
		list.add(app);
		
		pPApple(list, apple.new AppleFancyFormatter());
		pPApple(list, apple.new AppleSimpleFormatter());
	}
}
