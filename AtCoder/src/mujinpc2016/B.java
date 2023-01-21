package mujinpc2016;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l[] = new int[3];
		int max = 0;
		int min = 0;
		//求める図形はトーラス型になる。
		//大きい方の半径はすべての辺を足した値
		for(int i = 0; i < 3; i++) {
			l[i] = sc.nextInt();
			max += l[i];
		}
		//ソートした方が場合分けが楽
		Arrays.sort(l);
		
		//三角形を作れる場合は原点を触れる、つまり小さい方の半径が0
		if(l[0] + l[1] >= l[2]) {
			min = 0;
		}
		//三角形を作れない場合、足りない長さが小さい方の半径となる。
		else {
			min = l[2] - (l[1] + l[0]);
		}
		
		System.out.println((max*max - min*min)*Math.PI);
	}

}
