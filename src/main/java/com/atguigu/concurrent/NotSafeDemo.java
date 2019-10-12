package com.atguigu.concurrent;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo {
	public static void main(String[] args) {
		/*
		 * List list = new ArrayList();//ArrayList线程不安全的例子
		 * 
		 * list.add("a"); list.add("b"); list.add("c");
		 * 
		 * System.out.println(list);
		 * 
		 * // for (int i = 0; i < 3; i++) { for (int i = 0; i <30; i++) {
		 * 
		 * new Thread(() -> { list.add(UUID.randomUUID().toString().substring(0, 6));
		 * System.out.println(list);}, String.valueOf(i)).start();
		 * 
		 * }
		 */

		// List list = new Vector<>();
		// List list = Collections.synchronizedList(new ArrayList());
		List list = new CopyOnWriteArrayList<>();// 写时复制
		// for (int i = 0; i < 3; i++) {
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 6));
				System.out.println(list);
			}, String.valueOf(i)).start();

		}

	}

}
