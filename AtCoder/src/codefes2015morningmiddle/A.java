package codefes2015morningmiddle;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long m = sc.nextLong();
		long r = sc.nextLong();
		
		long score[] = new long[n - 1];
		
		for(int i = 0; i < n - 1; i++) {
			score[i] = sc.nextLong();
		}
		
		Arrays.parallelSort(score);
		
		long sum = 0;
				
		for(int i = 1; i <= k - 1; i++) {
			sum += score[n - i - 1];
		}
		
		long remain = r*k - sum;
		
		//最後の試験を受けなくても上位k回の平均点が基準を満たす場合
		//なおk=Nの場合は必ずあと1回試験を受けなければならない
		if(k <= n - 1 && remain <= score[n - k - 1]) {
			System.out.println(0);
		}
		//k-1回で必要な合計点を取っているなら0点でも可
		else if(remain <= 0) {
			System.out.println(0);
		}
		//残りの点数がMを超える場合は不可能
		else if(remain > m) {
			System.out.println(-1);
		}
		else {
			System.out.println(remain);
		}
	}

}
