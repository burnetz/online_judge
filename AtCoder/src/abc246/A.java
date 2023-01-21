package abc246;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numX[] = new int[202];
		int numY[] = new int[202];
		int offset = 100;
		
		for(int i = 0; i < 3; i++) {
			numX[sc.nextInt() + offset]++;
			numY[sc.nextInt() + offset]++;
		}
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < numX.length; i++) {
			if(numX[i] == 1) {
				x = i - offset;
			}
			
			if(numY[i] == 1) {
				y = i - offset;
			}
		}
		System.out.println((x) + " " + (y));
	}
}

