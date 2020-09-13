package abc178;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Point[] points = new Point[n];
		int xPlusYMax = 0;
		int xMinusYMax = Integer.MIN_VALUE;
		int xPlusYMin = Integer.MAX_VALUE;
		int xMinusYMin = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			points[i] = new Point(sc.nextInt(), sc.nextInt());
			int xPlusY = points[i].x + points[i].y;
			int xMinusY = points[i].x - points[i].y;

			xPlusYMax = Math.max(xPlusYMax, xPlusY);
			xPlusYMin = Math.min(xPlusYMin, xPlusY);
			xMinusYMax = Math.max(xMinusYMax, xMinusY);
			xMinusYMin = Math.min(xMinusYMin, xMinusY);
		}

		long result = Math.max(xPlusYMax - xPlusYMin, xMinusYMax - xMinusYMin);

		System.out.println(result);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

}