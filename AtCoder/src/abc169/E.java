package abc169;

import java.util.Arrays;
import java.util.Scanner;

public class E {

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
		Arrays.sort(a);
		Arrays.sort(b);

		//まず、Xのメジアンとして取りうるのがAのメジアン～Bのメジアンの間。
		//任意の要素を1増やすとXのメジアンはNが奇数なら0,1,Nが偶数なら0,1/2変化する。
		//それがAのメジアンからBのメジアンになるまで等間隔に発生するはず
		double medA, medB;
		if(n % 2 == 1){
			medA = a[n/2];
			medB = b[n/2];

			System.out.println((int)(medB - medA + 1));
		}
		else {
			medA = (a[n/2 - 1] + a[n/2])/2.0;
			medB = (b[n/2 - 1] + b[n/2])/2.0;
			System.out.println((int)((medB - medA)*2 + 1));
		}
	}

}
