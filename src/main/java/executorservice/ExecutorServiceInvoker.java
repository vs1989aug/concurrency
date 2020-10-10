package executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import executor.CallableTask;

public class ExecutorServiceInvoker {
	
	public void execute(CallableTask callableTask,ExecutorService executorService) throws TimeoutException, InterruptedException, ExecutionException {
		Future<Boolean> result = executorService.submit(callableTask);
		result.get(5, TimeUnit.MILLISECONDS);
	}

}
