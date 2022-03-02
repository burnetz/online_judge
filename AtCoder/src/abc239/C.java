package abc239;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long x1 = sc.nextLong();
		long y1 = sc.nextLong();
		long x2 = sc.nextLong();
		long y2 = sc.nextLong();
		
		int dx[] = {2,1,-1,-2,-2,-1,1,2};
		int dy[] = {1,2,2,1,-1,-2,-2,-1};
		
		for(int i = 0; i < 8; i++) {
			long tmpX = x1 + dx[i];
			long tmpY = y1 + dy[i];
//			System.out.println(tmpX + " , " + tmpY);
			long dX = x2 - tmpX;
			long dY = y2 - tmpY;
			
			long dist = dX*dX + dY*dY;
			
//			System.out.println("dist "+dist);
			if(dist == 5) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
}