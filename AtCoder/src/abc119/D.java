package abc119;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int q = sc.nextInt();
		
		long shrine[] = new long[a];
		for(int i = 0; i < a; i++) {
			shrine[i] = sc.nextLong();
		}
		long temple[] = new long[b];
		for(int i = 0; i < b; i++) {
			temple[i] = sc.nextLong();
		}
		
		for(int i = 0; i < q; i++) {
			long x = sc.nextLong();
			
			//問題の制約的に絶対ヒットしないので、符号反転で近いインデックスになる。
			int index1 = Arrays.binarySearch(shrine, x) * (-1) - 1;
			int index2 = Arrays.binarySearch(temple, x) * (-1) - 1;
			
			long shrineL = -2_000_000_000_0L;
			long shrineR = 2_000_000_000_0L;
			long templeL = -2_000_000_000_0L;
			long templeR = 2_000_000_000_0L;
			
			//xからちょっと右or左の神社と寺の座標を求める
			if(index1 >= 1) {
				shrineL = shrine[index1 - 1];
			}
			if(index2 >= 1) {
				templeL = temple[index2 - 1];
			}
			if(index1 < a) {
				shrineR = shrine[index1];
			}
			if(index2 < b) {
				templeR = temple[index2];
			}
			
			long result = Long.MAX_VALUE;
			
			//左にだけ進む場合
			result = Math.min(result, x - Math.min(templeL, shrineL));
			//右の神社と左の神社（xに戻る必要はないので片道が短い方だけを2回）
			result = Math.min(result, shrineR - templeL + Math.min(shrineR - x, x - templeL));
			result = Math.min(result, templeR - shrineL + Math.min(templeR - x, x - shrineL));
			result = Math.min(result, Math.max(templeR, shrineR) - x);
			
			System.out.println(result);
		}
	}
}
