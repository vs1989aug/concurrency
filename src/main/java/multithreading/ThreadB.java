package multithreading;

public class ThreadB extends Thread {
	
	Pattern p2;

	public ThreadB(Pattern p) {
		this.p2 = p;
	}

	@Override
	public void run() {

		synchronized (p2) {
			while (true) {
				while (p2.getStatus() != 2) {
					try {
						p2.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				System.out.println("B");
				p2.setStatus(1);
				p2.notifyAll();
			}
		}
	}

}
