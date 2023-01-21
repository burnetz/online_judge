package arc137;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//それぞれi文字目を終端とする部分文字列内での
		//1の個数 - 0の個数の最大値と最小値。
		int maxDiff[] = new int[n];
		int minDiff[] = new int[n];
		//できるだけ1が多い区間を反転すれば0を多くでき、
		//その逆によって1を多くできる。
		//なおかつ最大と最小の間は全て取りうる値である。
		int max = 0;
		int min = 0;
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				maxDiff[i] = minDiff[i] = a[i] == 1 ? 1 : -1;
			}
			
			else {
				if(a[i] == 0) {
					maxDiff[i] = Math.max(-1, maxDiff[i - 1] - 1);
					minDiff[i] = Math.min(-1, minDiff[i - 1] - 1);
				}
				else {
					maxDiff[i] = Math.max(1, maxDiff[i - 1] + 1);
					minDiff[i] = Math.min(1, minDiff[i - 1] + 1);
				}
				
			}
			
			max = Math.max(max, maxDiff[i]);
			min = Math.min(min, minDiff[i]);
			
		}
		
		System.out.println(max - min + 1);
		
	}
}