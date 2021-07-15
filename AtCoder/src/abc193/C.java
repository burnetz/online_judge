package abc193;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		long result = 0;
		boolean powered[] = new boolean[100_001];
		
		for(int i = 2; i <= 100000; i++) {
			if(powered[i]) {
				continue;
			}
			long tmp = (long)i*i;
			
			while(tmp <= 100000) {
				powered[(int)tmp] = true;
				tmp *= i;
			}
			result += Math.max(0, Math.floor(Math.log(n)/Math.log(i)) - 1);
		}
		
		System.out.println(n - result);
	}

}
