package arc029;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int t[] = new int[n];

		for(int i = 0; i < n; i++){
			t[i] = sc.nextInt();
		}

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < (int)Math.pow(2, n) ; i++){
			int t1 = 0;
			int t2 = 0;

			int tmp = i;
			for(int j = 0; j < n; j++){
				if(tmp % 2 == 0){
					t1 += t[j];
				}
				else {
					t2 += t[j];
				}

				tmp /= 2;
			}

			result = Math.min(result, Math.max(t1, t2));
		}

		System.out.println(result);
	}
}
