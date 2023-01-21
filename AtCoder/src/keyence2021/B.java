package keyence2021;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
	
		int count[] = new int[300002];
		
		for(int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}
		
		int max = k;
		long result = 0;
		for(int i = 0; i <= 300001; i++) {
			max = Math.min(count[i], max);
			if(max == 0) {
				break;
			}
			result += max;
		}
		
		System.out.println(result);
	}

}
