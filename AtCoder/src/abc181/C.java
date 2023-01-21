package abc181;

import java.util.Scanner;

public class C {

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
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int dxij = x[i] - x[j];
				int dyij = y[i] - y[j];
				for(int k = j + 1; k < n; k++) {
					int dxjk = x[j] - x[k];
					int dyjk = y[j] - y[k];
					
					if(dxij == 0) {
						if(x[i] == x[k]) {
//							System.out.println("(" +x[i] + ", "+y[i] + "), ("+x[j]+", "+y[j]+"), ("+x[k]+", "+y[k] + ")");
							count++;
						}
					}
					else {
						if(dxij*dyjk == dxjk*dyij) {
//							System.out.println("(" +x[i] + ", "+y[i] + "), ("+x[j]+", "+y[j]+"), ("+x[k]+", "+y[k] + ")");
							count++;
						}
					}
				}
			}
		}
		
//		System.out.println(count);
		System.out.println(count > 0 ? "Yes" : "No");
	}

}
