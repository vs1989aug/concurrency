package countdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountdownLatchTest {

	public static void main(String[] args) throws InterruptedException {

		/*CountDownLatch countDownLatch = new CountDownLatch(3);
		Stream.iterate(1, i -> i+1).map(threadId -> new Thread(new Task(countDownLatch), "Thread-" + threadId))
		.limit(5).forEach(Thread::start);
		
		new Thread(new Member(countDownLatch, "Vivek")).start();
		new Thread(new Member(countDownLatch, "Pawan")).start();
		new Thread(new Member(countDownLatch, "Prince")).start();
		
		countDownLatch.await();*/
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		new Thread(new MemberWithCyclicBarrier(cyclicBarrier, "Vivek")).start();
		new Thread(new MemberWithCyclicBarrier(cyclicBarrier, "Pawan")).start();
		new Thread(new MemberWithCyclicBarrier(cyclicBarrier, "Prince")).start();
		try {
			cyclicBarrier.await();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Amit D has joined the meeting.");

	}
	
	public static class Member implements Runnable{

		private CountDownLatch countdownlatch;
		private String memberName;
		
		public Member(CountDownLatch countdownlatch, String memberName) {
			super();
			this.countdownlatch = countdownlatch;
			this.memberName = memberName;
		}

		@Override
		public void run() {
			
			System.out.println(memberName+ " has joined the meeting.");
			countdownlatch.countDown();
			
		}
		
	}
	
	public static class MemberWithCyclicBarrier implements Runnable{

		private CyclicBarrier cyclicBarrier;
		private String memberName;
		
		public MemberWithCyclicBarrier(CyclicBarrier cyclicBarrier, String memberName) {
			super();
			this.cyclicBarrier = cyclicBarrier;
			this.memberName = memberName;
		}

		@Override
		public void run() {
			
			System.out.println(memberName+ " has joined the meeting.");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
