package com.atguigu.concurrent;

/**
 * 2    Lambda Express（前提是函数式接口，只有一个方法）
 *
 * 2.1 拷贝小括号，写死右箭头，落地大括号
 * 2.2 注解@FunctionalInterface
 * 2.3 default方法
 * 2.4 static
 *
 */
@FunctionalInterface//表明是函数式接口
interface Foo{//Lambda表达式的作用是创建函数式接口的对象并实现，不用写new，拷贝小括号，写死右箭头，落地大括号
	
	public int add(int x,int y);
	
	public default int div(int a,int b) {//default方法可以有多个
		return a/b;
	}
	/*public default int div1(int a,int b) {
		return a/b;
	}*/
	
	public static int mul(int x,int y) {//static方法可以有多个
		return x*y;		
	}
	/*public static int mul1(int x,int y) {
		return x*y;		
	}*/
	
}

public class LambdaExpressDemo {
	public static void main(String[] args) {
		Foo foo = new Foo() {
			
			@Override
			public int add(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}
		};
		
		Foo foo1 =(int x, int y) ->{
			
			System.out.println("-------------LambdaExpressDemo");
			return x+y;
		};
		System.out.println(foo1.add(4, 5));
		System.out.println(foo1.div(4, 2));
		System.out.println(Foo.mul(6, 2));
	}
}
