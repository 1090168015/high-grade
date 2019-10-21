package com.atguigu.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
	
	private volatile Map<String, String> map = new HashMap<>();
			
	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void put(String key,String value) {//正常情况下一条写操作必须操作完成才能进行下一次写操作，不允许加塞情况发生
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t写操作开始");
			
			map.put(key, value);
			System.out.println(Thread.currentThread().getName()+"\t写操作结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			readWriteLock.writeLock().unlock();
		}
		
	}
	
	public void get(String key) {
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t读操作开始");
			map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t读操作结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		readWriteLock.readLock().unlock();	
		}
	}
}


/**
 * @auther zzyy
 * @create 2019-02-20 14:08
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结：
 *          读-读能共存
 *          读-写不能共存
 *          写-写不能共存
 */
public class ReadWriteLockDemo {
	
	public static void main(String[] args) {
		MyCache myCache= new MyCache();
		for (int i = 1; i <=10; i++) {
			int finalI = i;
			new Thread(()->{
				myCache.put(finalI+"",finalI+"");
				
				
			}, String.valueOf(i)).start(); 
			
		}
		
		for (int i = 1; i <=10; i++) {
			int finalI=i;
			new Thread(() -> {
				myCache.get(finalI+"");
				
			}, String.valueOf(i)).start();
			
		}
		
	}
}
