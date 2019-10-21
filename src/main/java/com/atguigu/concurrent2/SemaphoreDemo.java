package com.atguigu.concurrent2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(3);//数字为1相当于加了synchronized
		
		for (int i = 1; i <=6; i++) {
			
			new Thread(() -> {
				boolean flag =false;//还没有抢到停车位
				try {
					semaphore.acquire();//抢占车位，车位减1，类比于CountDownLatch,死等 抢到位置
					flag=true;//抢到停车位
					System.out.println(Thread.currentThread().getName()+"\t抢到车位");
					TimeUnit.SECONDS.sleep(new Random().nextInt(5));
					System.out.println(Thread.currentThread().getName()+"\t车位离开");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if (flag) {//抢到车位才释放车位，判断是否抢到车位，finally每次都需要运行
						semaphore.release();//没释放一个车位，车位加1，CyclicBarrier
					}
				}
			
			}, String.valueOf(i)).start();
		}
		
		
	}

}
