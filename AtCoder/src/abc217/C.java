package abc217;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int p[] = new int[n];

		for(int i = 0; i < n; i++){
			p[i] = sc.nextInt() - 1;
		}

		int q[] = new int[n];

		for(int i = 0; i < n; i++){
			q[p[i]] = i + 1;
		}

		for(int i = 0; i < n; i++){
			if(i != 0){
				System.out.print(" ");
			}
			System.out.print(q[i]);
		}
		System.out.println();
	}
}
