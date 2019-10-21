package com.atguigu.concurrent2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 题目：三个售票员     卖出      30张票
 * 目的：如何写出企业级的多线程程序
 *
 *  ** 高内聚，低耦合
 *
 *  1 高内低耦的前提下，线程       操作          资源类
 *
 */
class Ticket{//资源类
	

	
	private int number =30;
	Lock  lock = new ReentrantLock();
	
	public void sale() {
		lock.lock();
		try {
			if (number>0) {
				System.err.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"剩余："+number);				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

}

public class SaleTicket {
	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		
		ExecutorService executor = new ThreadPoolExecutor(2,
				5, 2L,TimeUnit.SECONDS,new ArrayBlockingQueue<>(3) , Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
	
	
		//ExecutorService executor=Executors.newFixedThreadPool(3);
		for (int i = 1; i <=30; i++) {
			executor.submit(new FutureTask<String>(() ->{
				ticket.sale();
			//	System.err.println(Thread.activeCount());
				return "";
			}));
		}
		executor.shutdown();
	}
		
	}
	
	

		
		/*Ticket ticket = new Ticket();
		
		new Thread(new Runnable() {		
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sale();					
				}				
			}
		}, "A").start();		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sale();					
				}								
			}
		}, "B").start();		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sale();					
				}				
			}
		}, "C").start();*/
		

