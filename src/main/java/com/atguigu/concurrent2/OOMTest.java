package com.atguigu.concurrent2;

public class OOMTest {
	public static void main(String[] args) {
		new OOMTest().createObject();

	}

	public void createObject() {

		int max = Integer.MAX_VALUE / 2;

		Object[] objs = new Object[max];

		try {

			for (int i = 0; i < max; i++) {

				objs[i] = TestClass.class.newInstance();

			}

		} catch (InstantiationException e) {

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		}

	}

	static class TestClass {

	}

}
