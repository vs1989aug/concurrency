package exception;

@SuppressWarnings("serial")
public class CustomNameNotFoundException extends RuntimeException{
	
	public CustomNameNotFoundException(String error) {
		super(error);
	}

}
