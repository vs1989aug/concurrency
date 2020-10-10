package executor;

import java.util.concurrent.Executor;

public class Invoker implements Executor {

	public void execute(Runnable command) {
		command.run();
	}

}
