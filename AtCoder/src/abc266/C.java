package abc266;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x[] = new int[4];
		int y[] = new int[4];
		
		for(int i = 0; i < 4; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 4; i++) {
			int v0 = (i + 4 - 1)%4;
			int v1 = i;
			int v2 = (i + 1)%4;
			
			int v1x = x[v0] - x[v1];
			int v1y = y[v0] - y[v1];
			int v2x = x[v2] - x[v1];
			int v2y = y[v2] - y[v1];
			
			int crossZ = v1x*v2y - v2x*v1y;
			
			//外積のz成分の符号が異なる箇所があればそこが凹
			if(crossZ > 0) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
	
}