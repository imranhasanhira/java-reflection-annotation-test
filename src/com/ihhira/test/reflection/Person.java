package com.ihhira.test.reflection;

public class Person {
	public String name;
	public int age;

	public Person() {
		this("Default name", 0);
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
}
