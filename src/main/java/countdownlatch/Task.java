package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

	CountDownLatch countDownLatch;

	public Task(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " joined the conference.");
		countDownLatch.countDown();
	}

}
