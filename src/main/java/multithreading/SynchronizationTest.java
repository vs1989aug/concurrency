package multithreading;

/**
 * This program demonstrates that class level lock(static synchronized) and object level lock(synchronized) does not 
 * depend on each other in multi-threaded environment. 
 * A thread which is holding object level lock can execute synchronized methods and another thread which is holding
 * class level lock can execute static synchronized methods together.
 * @author vivsharm7
 *
 */
public class SynchronizationTest {
	
	public static void main(String[] args) {
		ColorProvider cp = new ColorProvider();
		Thread t1 = new Thread(()->{
			cp.display();
		});
		
		Thread t2 = new Thread(()->{
			ColorProvider.displayStatic();
		});
		
		t2.start();
		t1.start();
	}

}
