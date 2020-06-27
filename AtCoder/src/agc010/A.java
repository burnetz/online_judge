package agc010;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int odd = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			if(a[i]% 2 == 1){
				odd++;
			}
		}

		//足し算で新たに発生する数は必ず偶数なので
		//もともと奇数に余りがあると絶対に偶数と奇数が1つずつ残る
		if(odd % 2 == 1){
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}

	}
}
