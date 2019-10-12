package com.atguigu.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
	
	
	private int flag = 1;
	private Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3= lock.newCondition();
	
	public void print5() throws InterruptedException {
		
		lock.lock();
		try {
			while (flag != 1) {
				condition1.await();
				
			}
			
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
				
			}
			flag=2;
			condition2.signal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void print10() throws InterruptedException {
		
		lock.lock();	
		try {
			while (flag !=2) {//判断
				condition2.await();
			}
			for (int i = 1; i <= 10; i++) {//干活
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}	
			flag=3;
			condition3.signal();//通知
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
	public void print15() throws InterruptedException {
		lock.lock();
		try {
			while (flag !=3) {
				condition3.await();
				
			}
			for (int i = 1; i <=15; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
				
			}
			flag=1;
			condition1.signal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
		
		
	}
	
	
	
	
}
/**
 * @auther zzyy
 * @create 2019-06-25 8:17
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮
 *
 * 1    高聚低合前提下，线程操作资源类
 * 2    判断/干活/通知
 * 3    多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只用while，不能用if）
 */
public class ThreadOrderAccess {
	public static void main(String[] args) {
		
		ShareResource shareResource = new ShareResource();
		
		new Thread(() -> {for (int i = 1; i <= 10; i++) {
			try {
				shareResource.print5();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}, "AA").start();
		
		new Thread(() ->{ for (int i = 1; i <=10; i++) {
			try {
				shareResource.print10();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}, "BB").start();
		
		new Thread(() -> {for (int i = 1; i <=10; i++) {
			try {
				shareResource.print15();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}, "CC").start(); 
		
	}
}
