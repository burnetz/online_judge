package abc010;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int txa = sc.nextInt();
		int tya = sc.nextInt();
		int txb = sc.nextInt();
		int tyb = sc.nextInt();

		int t = sc.nextInt();
		int v = sc.nextInt();

		int n = sc.nextInt();

		boolean result = false;
		for(int i = 0; i < n; i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			if(dist(txa, tya, x1, y1) + dist(x1, y1, txb, tyb) <= v*t){
				result = true;
				break;
			}
		}

		System.out.println(result ? "YES" : "NO");
	}

	static double dist(int x0, int y0, int x1, int y1){
		return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
	}
}