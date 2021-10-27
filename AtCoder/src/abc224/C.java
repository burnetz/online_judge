package abc224;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Point[] points = new Point[n];
		
		for(int i = 0; i < n; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(points);
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					if(points[i].x == points[j].x) {
						if(points[j].x != points[k].x) {
							result++;
						}
					}
					else {
						if(points[j].x == points[k].x) {
							result++;
						}
						else {
							long dx1 = points[j].x - points[i].x;
							long dx2 = points[k].x - points[j].x;
							long dy1 = points[j].y - points[i].y;
							long dy2 = points[k].y - points[j].y;
							
							if(dx1 * dy2 != dx2 * dy1) {
								result++;
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	
	Point (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point p) {
		return this.x == p.x ? this.y - p.y : this.x - p.x;
	}
	
}