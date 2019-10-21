package com.atguigu.concurrent2;

import java.beans.FeatureDescriptor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*class MyThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
	//	System.out.println(Thread.activeCount());
		return "java 0615";
	}
	
}*/


public class CallableDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService  executorService = new ThreadPoolExecutor(2, 5, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
		try {
			executorService.execute(new FutureTask<String>(() ->{
				System.out.println(Thread.activeCount()+""+Thread.currentThread().getName());
				System.out.println("java 0615");
				return "java 0615";
			}));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
		
		/*FutureTask<String> futureTask = new FutureTask<>(new MyThread());
		
		new Thread(futureTask, "AAA").start();
		
	
		String string = futureTask.get();
		System.out.println(Thread.currentThread().getName());*/
		
		//	String string = futureTask.get();
		/*System.err.println(string);*/
		
	//	System.out.println(Thread.activeCount()+""+Thread.currentThread().getName());
		System.out.println(Thread.activeCount()+""+Thread.currentThread().getName());
		
		
	}

}
