package com.sist.bean;

public class Person {
	private int id = 20181004;
	private String name = "길순홍";
	
	public Person() {
		System.out.println("기본 생성자 동작함!");
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
