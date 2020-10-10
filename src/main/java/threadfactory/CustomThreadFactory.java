package threadfactory;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory{
	
	private final int threadId;

	
	public CustomThreadFactory(int threadId) {
		super();
		this.threadId = threadId;
	}

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r,"Thread_"+threadId);
	}

}
