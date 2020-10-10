package magicnumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MagicNumberTest {

	public static void main(String[] args) {
		int[][] distanceCordinates = new int[][] {{-2,2},{8,1},{2,2},{0,1}};
		int speed = 4;
		int input2=4;
		findMaxTime(distanceCordinates,speed,input2);
		
	}

	private static void findMaxTime(int[][] distanceCordinates, int speed, int input2) {
		List<Double> distances= new ArrayList<>();
		for(int i=0;i <distanceCordinates.length;i++) {
			for(int j=i+1;j<distanceCordinates.length;j++) {
				if(i != distanceCordinates.length-1) {
					int[] arr = distanceCordinates[i];
					int[] arr1 = distanceCordinates[j];
					double distance = Math.sqrt(((arr1[0]-arr[0])*(arr1[0]-arr[0])+(arr1[1]-arr[1])*(arr1[1]-arr[1])));
					System.out.println("Distance found: "+distance);
					distances.add(distance);
				}
			}
			
		}
		Double max = distances.stream().max(Comparator.comparing(Double::valueOf)).get();
		System.out.println("Max distance: "+max);
		Double maxtime = max/speed;
		double scale = Math.pow(10, 6);
		System.out.println("Max time: "+Math.round((maxtime*scale))/scale);
		
	}

}
