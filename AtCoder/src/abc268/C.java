package abc268;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//簡単のため一方後にしか回せないとする。
		//どれくらい回してほしいかを1人3票投票する。
		int vote[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			//真ん中と左右についてのループ。負の数になると面倒なので予めnを足して後でmodを取る。
			for(int j = n - 1; j <= n + 1; j++) {
				int diff = ((j + a[i]) - i)%n;
				vote[diff]++;
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(vote[i], max);
		}
		
		System.out.println(max);
		
	}
	
}