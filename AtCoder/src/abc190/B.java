package abc190;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int d = sc.nextInt();

		int x[] = new int[n];
		int y[] = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			if(x[i] < s && y[i] > d){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
