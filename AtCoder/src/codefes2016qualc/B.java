package codefes2016qualc;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int t = sc.nextInt();

		int a[] = new int[t];

		for(int i = 0; i < t; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		//一番数の多いケーキを食べ続けた場合の日数
		int result = a[t - 1] - 1;

		//もし連続でケーキを食べている日があればそこにi番目の種類のケーキを挟む。
		//ソート済みなのでこの操作によって新しく連続する箇所が発生することはなく
		//単調減少であることが保証される。
		for(int i = t - 2; i >= 0; i--){
			result = Math.max(0, result - a[i]);
		}

		System.out.println(result);
	}

}
