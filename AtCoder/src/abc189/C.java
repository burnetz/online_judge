package abc189;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//全区間を試すとO(N^2)だがNがそこまで大きくないので間に合う
		//各区間内の最小値をxとして合計が最大の区間を探す
		long result = 0;
		for(int i = 0; i < n; i++) {
			long tmpMin = Integer.MAX_VALUE;
			for(int j = i; j < n; j++) {
				tmpMin = Math.min(tmpMin, a[j]);
				
				result = Math.max(result, tmpMin * (j - i + 1));
			}
		}
		
		System.out.println(result);
	}

}
