package exception;

public class Sample {
	
	public String getSampleName() {
		// will produce stack overflow error
		return getSampleName();
	}

}
