package dwacon5th_prelims;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];

		double ave = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			ave += a[i];
		}

		ave /= n;

		double minDiff = 101;
		int minIndex = -1;
		for(int i = 0; i < n; i++){
			if(minDiff > Math.abs(a[i] - ave)){
				minDiff = Math.abs(a[i] - ave);
				minIndex = i;
			}
		}

		System.out.println(minIndex);
	}

}
