package com.atguigu.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {System.out.println(Thread.currentThread().getName()+"\t集齐7颗龙珠，召唤神龙");} );
		for (int i = 1; i <=7; i++) {
			int finalI = i;
			new Thread(() ->{
				
				
				try {
					System.out.println(Thread.currentThread().getName()+"\t集齐第"+finalI+"龙珠");
					cyclicBarrier.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			},String.valueOf(finalI)).start();			
		}
				
	}

}
