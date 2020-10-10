package countdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskWithCyclicBarrier implements Runnable {

	CyclicBarrier cyclicBarrier;

	public TaskWithCyclicBarrier(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " joined the conference.");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
