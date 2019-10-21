package com.atguigu.concurrent2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
	public static void main(String[] args) throws Exception {
		BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
		
	System.err.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));	
	System.err.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
	System.err.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
		
	/*	blockingQueue.put("a");
		blockingQueue.put("b");
		blockingQueue.put("c");
	//	blockingQueue.put("d");
		
		System.err.println(blockingQueue.take());
		System.err.println(blockingQueue.take());
		System.err.println(blockingQueue.take());
	//	System.err.println(blockingQueue.take());
*/		
		/*System.err.println(blockingQueue.offer("a"));
		System.err.println(blockingQueue.offer("b"));
		System.err.println(blockingQueue.offer("c"));
		System.err.println(blockingQueue.offer("d"));
		System.err.println(blockingQueue.poll());
		System.err.println(blockingQueue.poll());
		System.err.println(blockingQueue.poll());
		System.err.println(blockingQueue.poll());*/
		
		/*System.out.println(blockingQueue.add("a"));
		System.out.println(blockingQueue.add("b"));
		System.out.println(blockingQueue.add("c"));
	//	System.out.println(blockingQueue.add("d"));
		System.out.println(blockingQueue.element());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
	//	System.out.println(blockingQueue.remove());
*/	
	}

}
