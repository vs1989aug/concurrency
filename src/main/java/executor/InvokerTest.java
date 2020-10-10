package executor;

import java.util.concurrent.Executor;

public class InvokerTest {
	
	public static void main(String[] args) {
		Executor executor = new Invoker();
		executor.execute(()->{
			System.out.println("Sample runnable task using lambda.");
		});
	}

}
