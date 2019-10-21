package com.atguigu.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/*public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler)*/

public class MyThreadPoolDemo {
	public static void main(String[] args) {
			//ExecutorService executorService = Executors.newFixedThreadPool(5);////阻塞队列LinkedBlockingQueue，最大值Integer.MAX_VALUE,等候区成员太大请求速度大于 处理速度，队列的无限加入会造成资源耗尽，服务宕机
			//ExecutorService executorService = Executors.newSingleThreadExecutor();//阻塞队列LinkedBlockingQueue，最大值Integer.MAX_VALUE,等候区成员太大
			//ExecutorService executorService = Executors.newCachedThreadPool();//SynchronousQueue阻塞队列只有一个位置，即等候区只有一个
		ExecutorService executorService = new ThreadPoolExecutor(2, 
				5, 
				2L, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<>(3),//阻塞队列 
				 Executors.defaultThreadFactory(), 
				 //	 new ThreadPoolExecutor.AbortPolicy());
						new ThreadPoolExecutor.CallerRunsPolicy());
				// new ThreadPoolExecutor.DiscardOldestPolicy());
		// new ThreadPoolExecutor.DiscardPolicy());
			
				
		try {
			for (int i = 1; i <= 20; i++) {
				
				executorService.execute(() -> {System.out.println(Thread.currentThread().getName()+"\t办理业务"+new Random().nextInt(10));});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
	}

}
