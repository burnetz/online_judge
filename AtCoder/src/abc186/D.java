package abc186;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//ソートすればノーリスクで絶対値を外すことができ
		//総和を効率よく計算できるようになる
		Arrays.sort(a);
		long tmpSum = a[0];
		long result = 0;
		for(int i = 1; i < n; i++){
			result += (long)a[i]*i - tmpSum;
			tmpSum += a[i];
		}

		System.out.println(result);
	}

}
