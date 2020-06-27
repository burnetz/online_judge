package abc128;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int v[] = new int[n];
		for(int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
		}
		//一度取ったものを戻すときには順番が関係ないので
		//戻す作業を途中でやる意味がない（途中で戻すとまた取ることがあり手数の無駄）
		//戻したいものがあれば手数の余裕の範囲で最後に戻すことを考える
		int result = 0;
		//残る部分のサイズ
		for(int i = 0; i <= n; i++) {
			//手数が決まっているのでそれより多くは削れない
			if(n - i > k) {
				continue;
			}
			//残る部分の左端をずらす
			for(int j = 0; j < n ; j++) {
				if(j + i > n) {
					break;
				}
				//残すところを0とする（後でループで総和を計算するのが楽）
				int mask[] = new int[n];
				Arrays.fill(mask, 1);
				
				for(int l = j; l < j + i; l++) {
					mask[l] = 0;
				}
				
				int resArray[] = new int[n];
				//残す部分は0としてデータを残しても実害はない
				for(int l = 0; l < n; l++) {
					resArray[l] = mask[l]*v[l];
				}
				
				Arrays.sort(resArray);
				//手数が余っているうちはマイナスを捨てる
				for(int l = 0; l < k - (n - i) ; l++) {
					if(resArray[l] >= 0) {
						break;
					}
					resArray[l] = 0;
				}
				
				
				int tmpSum = 0;
				for(int l = 0; l < n; l++) {
					tmpSum += resArray[l];
				}
				result = Math.max(result, tmpSum);
			}
		}
		
		System.out.println(result);
	}

}
