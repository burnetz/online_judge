package abc187;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x[] = new int[n];
		int y[] = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(x[i] == x[j]){
					continue;
				}

				double a = (double)(y[i] - y[j])/(x[i] - x[j]);

				if(Math.abs(a) <= 1){
					count++;
				}
			}
		}

		System.out.println(count);
	}

}
