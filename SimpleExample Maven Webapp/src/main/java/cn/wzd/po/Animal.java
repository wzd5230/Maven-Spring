package cn.wzd.po;

import org.springframework.stereotype.Component;

@Component("animal")
public class Animal {
	
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void say(){
		System.out.println("I'm animal.");
		System.out.println("My name is "+this.name+",I'm "+this.age+" years old.");
	}
	

}
