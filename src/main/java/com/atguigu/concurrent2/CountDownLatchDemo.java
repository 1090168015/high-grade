package com.atguigu.concurrent2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	public static void main(String[] args) throws Exception {
		{
	        CountDownLatch countDownLatch = new CountDownLatch(6);

	        for (int i = 1; i <=6; i++) {
	            new Thread(() -> {
	               /* try {
	                    Thread.sleep(4000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }*/
	                System.out.println(Thread.currentThread().getName()+"\t离开教室");
	                countDownLatch.countDown();
	            },String.valueOf(i)).start();
	        }

	        //  countDownLatch.await();
	        countDownLatch.await(2L,TimeUnit.SECONDS);
	        System.out.println(Thread.currentThread().getName()+"\t 关门离开");

		}    
	}
}
