package abc117;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		if(m <= n){
			System.out.println(0);
			return;
		}

		int x[] = new int[m];

		for(int i = 0; i < m; i++){
			x[i] = sc.nextInt();
		}

		//右にしか移動しないと決めた場合、
		//回数最小化のためには距離が長いところを移動せずに済むようにコマを配置するのが最適
		Arrays.sort(x);
		int left[] = new int[m];
		int sum = 0;
		for(int i = 1; i < m; i++){
			left[i] = x[i] - x[i - 1];
			sum += left[i];
		}
		Arrays.sort(left);

		//1つ目は左端固定なので、移動をさぼれる回数はn - 1回
		int skippable = 0;
		for(int i = 0; i < n - 1; i++){
			skippable += left[m - i - 1];
		}


		System.out.println(sum - skippable);
	}
}
