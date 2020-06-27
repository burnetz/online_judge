package agc009;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long a[] = new long[n];
		long b[] = new long[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextLong();
			b[i] = sc.nextLong();
		}

		//例えばn番目の要素は[1,n]の加算でしか調整できないので
		//n番目から順に値を確定させていけばよい
		long add = 0;
		for(int i = n - 1; i >= 0; i--){
			if((a[i] + add)%b[i] != 0){
				add += b[i] - (a[i] + add)%b[i];
			}
		}

		System.out.println(add);
	}
}
