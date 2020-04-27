package abc125;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//操作によってマイナスを片側に寄せることができるので
		//最終的にはマイナスの偶奇が重要になる。
		//ただし1個でも0があれば偶奇にかかわらず全てのマイナスを排除できる
		//マイナスが1個残る場合は最も絶対値が小さいものをマイナス扱いにすればよい
		int a[] = new int[n];
		int minus = 0;
		int zero = 0;
		int minAbs = Integer.MAX_VALUE;
		long absSum = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			if(a[i] < 0){
				minus++;
			}
			if(a[i] == 0){
				zero++;
			}
			minAbs = Math.min(Math.abs(a[i]), minAbs);

			absSum += Math.abs(a[i]);
		}

		if(minus % 2 == 0 || zero > 0){
			System.out.println(absSum);
		}
		else {
			System.out.println(absSum - minAbs*2);
		}

	}

}