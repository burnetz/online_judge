package dwango2016qual;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n - 1];

		for(int i = 0; i < n - 1; i++){
			a[i] = sc.nextInt();
		}

		int b[] = new int[n];
		Arrays.fill(b, Integer.MAX_VALUE);

		//前から順に数字を決めていく。
		//特に前の数字よりも小さい場合は左側も更新する必要がある。
		//右側は無条件で同じ数字にしてよい。
		for(int i = 0; i < n - 1; i++){
			b[i] = Math.min(b[i], a[i]);
			b[i + 1] = a[i];
		}

		for(int i = 0; i < n ; i++){
			System.out.print(b[i]);
			if(i != n - 1){
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
