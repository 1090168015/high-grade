package com.atguigu.classload;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

public class JavaHeapWorkSpaceDemo {
	public static void main(String[] args) {
		
		
		String str = "www.atguigu.com" ;
		while(true) 
		{
		str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
		}		
	}	
}

