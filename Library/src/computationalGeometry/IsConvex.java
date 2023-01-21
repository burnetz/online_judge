package computationalGeometry;

import java.util.Scanner;

public class IsConvex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];

		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++) {
			int v0 = (i + n - 1)%n;
			int v1 = i;
			int v2 = (i + 1)%n;

			int v1x = x[v0] - x[v1];
			int v1y = y[v0] - y[v1];
			int v2x = x[v2] - x[v1];
			int v2y = y[v2] - y[v1];

			int crossZ = v1x*v2y - v2x*v1y;

			//外積のz成分の符号が異なる箇所があればそこが凹
			if(crossZ > 0) {
				System.out.println("0");
				return;
			}
		}

		System.out.println("1");
	}

}
