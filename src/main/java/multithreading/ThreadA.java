package multithreading;

public class ThreadA extends Thread {

	Pattern p1;

	public ThreadA(Pattern p) {
		this.p1 = p;
	}

	@Override
	public void run() {

		synchronized (p1) {
			while (true) {
				while (p1.getStatus() != 1) {
					try {
						p1.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				System.out.println("A");
				p1.setStatus(2);
				p1.notifyAll();
			}
		}
	}

}
