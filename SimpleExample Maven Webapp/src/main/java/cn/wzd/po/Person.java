package cn.wzd.po;

public class Person {
	
	private String name;
	private int age;
	private String address;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void say(){
		System.out.println("Hello,I'm "+this.name);
		System.out.println("I'm "+this.age+" years old.");
		System.out.println("My home is in "+this.address);
	}

}
