package arc051;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int r = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		
		boolean d1 = dist(x1,y1,x2,y2) <= r;
		boolean d2 = dist(x1,y1,x2,y3) <= r;
		boolean d3 = dist(x1,y1,x3,y2) <= r;
		boolean d4 = dist(x1,y1,x3,y3) <= r;
			
		if(x1 - r < x2 || y1 - r < y2 || x1 + r > x3 || y1 + r > y3) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		if(d1 && d2 && d3 && d4) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
	}
	
	static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); 
	}

}