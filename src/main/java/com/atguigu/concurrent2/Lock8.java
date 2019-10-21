package com.atguigu.concurrent2;

import java.util.concurrent.TimeUnit;

class Phone{
	
	public static synchronized void sendEmail() throws Exception {//发邮件
		System.out.println("开始输出");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("**************sendEmail");
		
		
	}
	
	public  synchronized void sendSMS() {//发短信
		System.out.println("**************sendSMS");
	}
	
	public  void hello() {
		System.out.println("**************SayHello");
	}
	
	
	
}
/** 题目：多线程8锁
* 1    标准访问，请问先打印邮件还是短信？
* 2    邮件方法新增暂停4秒钟，请问先打印邮件还是短信？
* 3    新增普通hello方法，，请问先打印邮件还是hello？
* 4    两部手机，，请请问先打印邮件还是短信？
* 5    两个静态同步方法，1部手机，请请问先打印邮件还是短信？
* 6    两个静态同步方法，2部手机，请请问先打印邮件还是短信？
* 7    1个静态同步方法，1个普通同步方法,1部手机，请请问先打印邮件还是短信？
* 8    1个静态同步方法，1个普通同步方法,2部手机，请请问先打印邮件还是短信？*/

public class Lock8 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		Phone phone2 = new Phone();
		
		new Thread(() ->{try {
			phone.sendEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}, "A") .start();
		
		new Thread(() ->{phone.sendSMS();}, "B").start();
		
		//	new Thread(() ->{phone.hello();} , "C").start();
		
	}

}
