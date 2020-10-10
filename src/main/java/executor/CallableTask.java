package executor;

import java.util.concurrent.Callable;

import com.sapient.concurrency.User;

public class CallableTask implements Callable<Boolean> {
	
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean call() throws Exception {
		boolean loginSuccess = new User(getUserName(),getPassword()).login();
		if(loginSuccess) {
			System.out.println("login is successful.");
		}
		else {
			System.out.println("failed login.");
		}
		return loginSuccess;
	}
	
}
