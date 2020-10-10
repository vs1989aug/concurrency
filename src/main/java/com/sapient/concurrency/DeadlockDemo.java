package com.sapient.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {

	private static Lock obj1 = new ReentrantLock();
	private static boolean flag;
	public static void main(String[] args) {
	
		Thread t1 = new Thread(()->{
			obj1.lock();
			if(flag) {
				obj1.unlock();
			}
		});
		
		Thread t2 = new Thread(()->{
			obj1.lock();
			flag = true;
		});

		t1.start();
		t2.start();
	}

}
