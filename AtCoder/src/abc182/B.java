package abc182;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int max = 0;
		int result = -1;
		for(int i = 2; i <= 1000; i++){
			int tmp = 0;
			for(int j = 0; j < n; j++){
				if(a[j] % i == 0){
					tmp++;
				}
			}

			if(max < tmp){
				max = tmp;
				result = i;
			}

		}

		System.out.println(result);
	}

}
