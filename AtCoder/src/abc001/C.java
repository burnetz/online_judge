package abc001;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int degInt = sc.nextInt()*10;
		int disInt = sc.nextInt();
		
		String dir = "N";
		String dirArray[] = {"N", "NNE","NE","ENE","E","ESE","SE","SSE","S","SSW","SW","WSW","W","WNW","NW","NNW"};

		for(int i = 1; i <= 15; i++) {
			if(degInt >= 2250*i - 1125 && degInt < 2250*(i + 1) - 1125) {
				dir = dirArray[i];
				break;
			}
		}
		
		int powerLimit[] = {2,15,33,54,79,107,138,171,207,244,284,326};
		
		double dis = Math.round(disInt/6.0);
		int power = 12;
		for(int i = 0; i < powerLimit.length; i++) {
			if(dis <= powerLimit[i]) {
				power = i;
				break;
			}
		}
		
		if(power != 0) {
			System.out.println(dir + " " + power);
		}
		else {
			System.out.println("C 0");
			
		}
	}

}