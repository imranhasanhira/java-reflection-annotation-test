/**
 * File : ReflectionTestMain.java
 *
 * Copyright (C) 2014, KONA Software Lab Ltd. All rights reserved.
 *
 * This program is a property of KONA Software Lab Ltd. You can not redistribute it and/or modify it
 * without any permission of KONA Software Lab Ltd.
 *
 * @author : Md Imran Hasan Hira ( hasan.hira@konasl.com )
 * @created : Dec 1, 2014 : 6:26:23 PM
 */

package com.ihhira.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Md Imran Hasan Hira ( hasan.hira@konasl.com )
 * 
 */
public class ReflectionTestMain {
	public static void main(String[] args) throws ClassNotFoundException {

		// testClassGetting();

		// createNewInstanceTest();

		// testPersonParser();
		// testPersonParserReflective();

		// testFindFieldsUpToSuperClass();

		// testMethodCall();

	}

	private static void testClassGetting() throws ClassNotFoundException {
		// Compile Time
		Class cls1 = String.class;

		// Runtime (First)
		Class cls2 = Class.forName("java.lang.String");

		// Runtime (Second)
		String str = "I'm a string";
		Class cls3 = str.getClass();
	}

	private static void testMethodCall() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {

		Class personClass = Class.forName("com.ihhira.test.reflection.Person");

		Object object = personClass.newInstance();
		System.out.println(object.toString());

		Method setNameMethod = personClass.getMethod("setName", String.class);
		setNameMethod.invoke(object, "Dynamic name");
		System.out.println(object.toString());

	}

	private static void testFindFieldsUpToSuperClass() {
		try {

			Object obj = new Object(); // the object
			String fieldName = "power"; // field name to search
			Class cls = obj.getClass();
			while (cls != null) {
				Field field = cls.getDeclaredField(fieldName);
				if (field == null) {
					cls = cls.getSuperclass();
					continue;
				}

				System.out.println("Field found :)");
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		// System.out.println("Field not found :(");
	}

	private static void testPersonParserReflective() {
		PersonParser personParser = new PersonParser();
		try {
			System.out.println(byte.class.getName());
			Person person = (Person) personParser.parseSinglePersonReflective(
					"Sunny Sunny : 15",
					Class.forName("com.ihhira.test.reflection.Person"));
			System.out.println(person.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testPersonParser() {
		PersonParser personParser = new PersonParser();
		Person person1 = personParser.parseSinglePerson("Sunny sunny : 16");
		System.out.println(person1.toString());

	}

	private void createNewInstanceTest() {
		try {
			Class personClass = Person.class;
			Object o = personClass.newInstance();
			Person person = (Person) o;
			System.out.println(person.toString());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
