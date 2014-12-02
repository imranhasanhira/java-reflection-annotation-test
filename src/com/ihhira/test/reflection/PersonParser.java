package com.ihhira.test.reflection;

import java.lang.reflect.Field;

public class PersonParser {

	public Person parseSinglePerson(String dataString) {
		String[] data = dataString.split(":");
		String name = data[0];
		int age = Integer.parseInt(data[1].trim());
		return new Person(name, age);
	}

	public <T> T parseSinglePersonReflective(String dataString, Class<T> cls)
			throws InstantiationException, IllegalAccessException {

		T object = (T) cls.newInstance();

		String[] data = dataString.split(":");
		Field[] declaredFields = cls.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			if (field.getType() == int.class) {
				field.set(object, Integer.parseInt(data[i].trim()));
			} else if (field.getType() == String.class) {
				field.set(object, data[i]);
			}
		}
		return object;
	}

}
