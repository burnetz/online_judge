package agc040;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] input = sc.next().toCharArray();

		int n = input.length + 1;
		int a[] = new int[n];

		//右からも左からも上り坂はできれば0からスタートが良い
		//まずは左から構成していく
		for(int i = 1; i < n; i++){
			if(input[i - 1] == '<'){
				a[i] = a[i - 1] + 1;
			}
			else {
				a[i] = 0;
			}
		}

		//右からの構成もほぼ同様だが
		//前工程で最低限必要な高さを記録しているのでそれより低くはできない
		for(int i = n - 2; i >= 0; i--){
			if(input[i] == '>'){
				a[i] = Math.max(a[i], a[i + 1] + 1);
			}
		}

		long sum = 0;
		for(int i = 0; i < n; i++){
			sum += a[i];
		}

		System.out.println(sum);
	}

}
