package com.atguigu.concurrent2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner {
	
	private int number=0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void increment() throws Exception {
		lock.lock();
		try {
			while (number != 0) {
				condition.await();

			}
			number++;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			condition.signalAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
	public void decrement() throws InterruptedException {
		lock.lock();
		try {
			while (number == 0) {
				condition.await();
				
			}
			number--;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			condition.signalAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	/*public synchronized void increment() throws Exception {
		while(number!=0) {
			this.wait();
			
		}
		number++;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		
		this.notifyAll();

	}

	public synchronized void decrement() throws Exception {
		while(number==0) {
			this.wait();
			
		}
		number--;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		
		this.notifyAll();
	}
*/
}

/**
 * @auther zzyy
 * @create 2019-02-19 8:44 题目：现在两个线程，可以操作初始值为零的一个变量， 实现一个线程对该变量加1，一个线程对该变量减1，
 *         实现交替，来10轮，变量初始值为零。
 *
 *         1 高聚低合前提下，线程操作资源类 
 *         2 判断/干活/通知 
 *         3 防止虚假唤醒，如果有使用wait的地方，需要用while而不是if判断
 *
 */
public class ThreadWaitNotifyDemo {
	public static void main(String[] args) {

		AirConditioner conditioner = new AirConditioner();
		
		new Thread(() -> {for (int i = 1; i <= 100; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(20);
				conditioner.increment();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}} , "A").start(); 
		
		new Thread(() -> {for(int i = 1; i <= 100; i++) {
			
			try {
				TimeUnit.MICROSECONDS.sleep(40);
				conditioner.decrement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}, "B").start();
		
		new Thread(() -> {for (int i = 1; i <=100; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(60);
				conditioner.increment();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}}, "C").start();
		new Thread(() -> {for (int i = 1; i <= 100; i++) {
			try {
				TimeUnit.MICROSECONDS.sleep(80);
				conditioner.decrement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}}, "D").start();
		
		
		/*new Thread(new Runnable() {
		
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						conditioner.increment();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		}, "A").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						conditioner.decrement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}			
			}
		}, "B").start();
		*/
		
	}

}
