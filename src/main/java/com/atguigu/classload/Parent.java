package com.atguigu.classload;

public class Parent {
		 int a = 10;
		 static int b = 11;
	 // 静态代码块
	 static {
		System.out.println("Parent静态代码块：b=" + b);
		b++;
	}
	 // 代码块
	 {
		 System.out.println("Parent代码块： a=" + a);
		 System.out.println("Parent代码块： b=" + b);
		 b++;
		 a++;
	 }
	// 无参构造函数
	 Parent() {
		 System.out.println("Parent无参构造函数： a=" + a);
		 System.out.println("Parent无参构造函数： b=" + b);
	 }
	
	 // 有参构造函数
	 Parent(int a) {
		 System.out.println("Parent有参构造函数： a=" + a);
		 System.out.println("Parent有参构造函数： b=" + b);
	 }
	 // 方法
	 	void function() {
		 System.out.println("Parent function run ……");
	 }
	 	 // 方法
	 	void run() {
		 System.out.println("父类run ……");
	 }
}
