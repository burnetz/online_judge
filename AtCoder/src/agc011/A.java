package agc011;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		int t[] = new int[n];

		for(int i = 0; i < n; i++){
			t[i] = sc.nextInt();
		}
		Arrays.sort(t);

		int arrive = t[0] + k;
		int ride = 0;
		int num = 1;

		//新しいバスを用意せざるを得ないときにi番目の客が乗れるギリギリ遅い時間にするのが最適
		for(int i = 0; i < n; i++){
			if(arrive >= t[i] && t[i] + k >= arrive && ride < c){
				ride++;
			}
			else{
				num++;
				ride = 1;
				arrive = t[i] + k;
			}

		}
		System.out.println(num);
	}
}
