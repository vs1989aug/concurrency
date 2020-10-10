package threadfactory;

public class CustomThreadfactoryTest {

	public static void main(String[] args) {
		
		final int id = 1;
		
		Runnable task = () ->{
			System.out.println(Thread.currentThread().getName()+ " is Running task.");
		};
		
		CustomThreadFactory factory = new CustomThreadFactory(id);
		factory.newThread(task).start();

	}

}
