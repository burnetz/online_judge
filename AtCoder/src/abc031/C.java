package abc031;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

		}

		int maxSumT = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			int maxJ = 0;
			int maxSumA = Integer.MIN_VALUE;
			for(int j = 0; j < n; j++){
				if(i == j){
					continue;
				}

				int tmpSum = 0;
				for(int k = Math.min(i,j) + 1 ; k <= Math.max(i, j) ; k += 2){
					tmpSum += a[k];
				}

				if(tmpSum > maxSumA){
					maxSumA = tmpSum;
					maxJ = j;
				}
			}

			int tmpSum = 0;
			for(int k = Math.min(i,maxJ) ; k <= Math.max(i, maxJ) ; k += 2){
				tmpSum += a[k];
			}

			maxSumT = Math.max(maxSumT, tmpSum);
		}

		System.out.println(maxSumT);

	}
}