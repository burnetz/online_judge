package arc020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int c = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int total = Integer.MAX_VALUE;
		for(int i = 1; i <= 10; i++){
			for(int j = 1; j <= 10; j++){
				int tmp = 0;
				if(i == j){
					continue;
				}

				for(int k = 0; k < n; k++){
					if(k % 2 == 0 && a[k] != i){
						tmp += c;
					}

					if(k %2 == 1 && a[k] != j){
						tmp += c;
					}
				}
				total = Math.min(total, tmp);
			}


		}

		System.out.println(total);
	}
}
