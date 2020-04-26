package arc004;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int d[] = new int[n];

		int max = 0;
		for(int i = 0; i < n; i++){
			d[i] = sc.nextInt();
			max += d[i];
		}

		int min = 0;
		if(n == 1){
			min = d[0];
		}
		else if(n == 2){
			min = Math.abs(d[0] - d[1]);
		}
		//多角形の場合、一番長い辺の長さがそれ以外の辺の合計よりも短ければ原点と点nの距離をうまく0にできる
		//一番長い辺が長すぎる場合はどうやってもそれ以外の合計との差にしかならない
		else {
			Arrays.sort(d);

			int tmpSum = 0;
			for(int i = 0; i < n - 1; i++){
				tmpSum += d[i];
			}

			if(tmpSum < d[n - 1]){
				min = d[n - 1] - tmpSum;
			}
			else {
				min = 0;
			}
		}

		System.out.println(max);
		System.out.println(min);
	}
}