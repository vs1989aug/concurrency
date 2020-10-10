package com.sapient.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleTest {

	public static void main(String[] args) {
		
		List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<Integer>());
		Runnable task = ()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronizedList.addAll(Arrays.asList(1,2,3,4,5));
			System.out.println(synchronizedList);
		};
		
		Thread t1 = new Thread(task);
		t1.start();
		Thread t2 = new Thread(task);
		t2.start();
		try {
			t1.join();
			System.out.println("Child thread ended so main thread continued.. size of sync collection: "+synchronizedList.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
