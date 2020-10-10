package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABTest {
	
	public static void main(String[] args) {

		int x = 0;
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		while(x<5) {
			try {
				service.submit(getTask("A")).get();
				service.submit(getTask("B")).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}			
			x++;
		}
		
	}

	private static Callable<String> getTask(String task) {
		return ()->{
			System.out.print(task+",");
			Thread.sleep(500);
			return task;
		};
	}

}
