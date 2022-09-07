package arc147;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		StringBuffer sb = new StringBuffer();
		int count = 0;
		
		//今回の問題ではBは何回やってもいい。
		//Aを使わなければいけないのは「偶数があるべきところに奇数がある」およびその逆のパターンを修正するとき。
		//最小の回数にするためには不適切な偶数および不適切な奇数を隣接させる必要がある。
		while(true) {
			int invalidOdd = -1;
			int invalidEven = -1;
			
			for(int i = 0; i < n; i += 2) {
				if(a[i]%2 == 0) {
					invalidEven = i;
					break;
				}
			}
			
			for(int i = 1; i < n; i += 2) {
				if(a[i]%2 == 1) {
					invalidOdd = i;
					break;
				}
			}
			
			if(invalidOdd == -1) {
				break;
			}
			
			int l = Math.min(invalidOdd, invalidEven);
			int r = Math.max(invalidEven, invalidOdd);
			
			//隣接させるまでのステップはBを使う。この場合適切な数字には影響がない。
			for(int i = l; i <= r - 3; i += 2) {
				int tmp = a[i];
				a[i] = a[i + 2];
				a[i + 2] = tmp;
				
				count++;
				sb.append("B "+(i + 1) + "\n");
			}
			
			//この時点で不適切な数字が1組適切な場所に移動する。
			int tmp = a[r - 1];
			a[r - 1] = a[r];
			a[r] = tmp;
			
			count++;
			sb.append("A "+r + "\n");
		}
		
		//あとは偶数番目だけ、および奇数番目だけをソートすればOK
		//200^2を2回なので条件を満たす
		for(int i = 0; i < n; i += 2) {
			for(int j = 0; j < n - 2; j += 2) {
				if(a[j] > a[j + 2]) {
					int tmp = a[j];
					a[j] = a[j + 2];
					a[j + 2] = tmp;
					
					count++;
					sb.append("B "+(j + 1) + "\n");
				}
			}
		}
		
		for(int i = 1; i < n; i += 2) {
			for(int j = 1; j < n - 2; j += 2) {
				if(a[j] > a[j + 2]) {
					int tmp = a[j];
					a[j] = a[j + 2];
					a[j + 2] = tmp;
					
					count++;
					sb.append("B "+(j + 1) + "\n");
				}
			}
		}
		
		System.out.println(count);
		System.out.print(sb);
		
	}

}