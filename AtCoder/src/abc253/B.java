package abc253;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
		
		for(int i = 0; i < h; i++) {
			String str = sc.next();
			for(int j = 0; j < w ; j++) {
				if(str.charAt(j) == 'o') {
					if(x1 < 0) {
						x1 = j; 
						y1 = i;
					}
					else {
						x2 = j;
						y2 = i;
					}
				}
			}
		}
		
		System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}
}