package abc133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int a[] = new int[n];

		String[] tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			a[i] = Integer.parseInt(tmpArray[i]);
		}

		long[] x = new long[n];
		//まずはx1を確定させる
		for(int i = 0; i < n; i++){
			if(i %2 == 0){
				x[0] += a[i];
			}
			else {
				x[0] -= a[i];
			}
		}
		x[0] /= 2;


		for(int i = 1; i < n; i++){
			x[i] = a[i - 1] - x[i - 1];
		}

		for(int i = 0; i < n; i++){
			if(i != 0){
				System.out.print(" ");
			}
			System.out.print(x[i]*2);
		}
		System.out.println();
	}

}
