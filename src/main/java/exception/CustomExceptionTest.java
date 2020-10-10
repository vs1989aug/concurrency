package exception;

import java.util.Scanner;

public class CustomExceptionTest {

	public static void main(String[] args) {
		String name=null;
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter a name.");
			name= sc.next();
			if(!name.equalsIgnoreCase("vivek")) {
				throw new CustomNameNotFoundException("Incorrect name: "+ name);
			}
			System.out.println("correct name : "+name);
		}

	}

}
