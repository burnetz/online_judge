package abc214;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int s[] = new int[n];
		int t[] = new int[n];

		for(int i = 0; i < n; i++){
			s[i] = sc.nextInt();
		}

		int start = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			t[i] = sc.nextInt();

			if(t[i] < min){
				min = t[i];
				start = i;
			}
		}

		long result[] = new long[2*n];

		result[start] = t[start];
		for(int i = start + 1; i < start + n; i++){
			result[i] = Math.min(t[i%n], result[i - 1] + s[(i - 1)%n]);
		}

		for(int i = 0; i < start; i++){
			result[i] = result[i + n];
		}

		for(int i = 0; i < n; i++){
			System.out.println(result[i]);
		}
	}

}
