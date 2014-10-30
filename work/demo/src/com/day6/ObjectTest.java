package com.day6;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class ObjectTest {

    public static void main(String[] args) {

   		class Foo {}

		Class<?>[] ancestors = getAncestors(new Foo());
		if(ancestors[0]==Foo.class)
			System.out.println("1");
		if(ancestors[1]==Object.class)
			System.out.println("2");
	}

	private static Class<?>[] getAncestors(Object object) {
		List<Class<?>> ancestors = new ArrayList<Class<?>>();
		Class<?> clazz = object.getClass();
		while(clazz != null) {
			ancestors.add(clazz);
			clazz = clazz.getSuperclass();
		}
		return ancestors.toArray(new Class[]{});
	}

}
