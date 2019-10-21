package com.atguigu.concurrent;

import java.beans.FeatureDescriptor;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
	//	System.out.println(Thread.activeCount());
		System.out.println(Thread.activeCount());
		return "java 0615";
		
	}
	
}


public class CallableDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<>(new MyThread());
		System.out.println("--------------"+Thread.activeCount()+""+Thread.currentThread().getName());
		
		new Thread(futureTask, "AAA").start();
		String string = futureTask.get();
		System.out.println("--------------"+Thread.activeCount()+""+Thread.currentThread().getName());
		
		//	String string = futureTask.get();
		System.err.println(string);
		
	//	System.out.println(Thread.activeCount()+""+Thread.currentThread().getName());
		
		
		
	}

}
