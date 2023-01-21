package abc194;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int tmp;
				if(i == j){
					tmp = a[i] + b[j];
				}
				else {
					tmp = Math.max(a[i], b[j]);
				}

				result = Math.min(result, tmp);
			}
		}

		System.out.println(result);

	}

}

