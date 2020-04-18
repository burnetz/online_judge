package arc042;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int startX = sc.nextInt();
		int startY = sc.nextInt();
		int n = sc.nextInt();
		
		Point2D points[] = new Point2D[n];
		
		for(int i = 0; i < n; i++) {
			points[i] = new Point2D.Double(sc.nextInt(), sc.nextInt());
		}
		
		Line2D lines[] = new Line2D[n];
		double result = Double.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			lines[i] = new Line2D.Double(points[i], points[(i + 1)%n]);
			
			result = Math.min(result, lines[i].ptLineDistSq(startX, startY));
		}
		
		System.out.println(Math.sqrt(result));
	}		
}

