package multithreading;

public class ColorProvider {

	static String color;
	public synchronized void display() {
		color="RED12345";
		System.out.println("Instance method: "+color.substring(color.length()-4));
	}

	public static synchronized void displayStatic() {
		System.out.println("Static method: "+ color);
	}
	
	/*private static class Color{
		private String colorValue;
		
		public String getColorValue() {
			return colorValue;
		}
	}*/

}
