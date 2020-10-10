package executorservice;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import executor.CallableTask;

public class ExecutorServiceInvokerTest {

	public static void main(String[] args){
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Enter user name: ");
			String userName = scanner.next();
			System.out.println("Enter password: ");
			String password = scanner.next();
			CallableTask task = new CallableTask();
			task.setUserName(userName);
			task.setPassword(password);
			
			ExecutorService executorService = Executors.newFixedThreadPool(1);

			new ExecutorServiceInvoker().execute(task,executorService);
			if(!executorService.isTerminated()) {
				executorService.awaitTermination(1, TimeUnit.MILLISECONDS);	
				System.out.println("Executor service is shut down.");
			}
		}
		catch(InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
	}

}
