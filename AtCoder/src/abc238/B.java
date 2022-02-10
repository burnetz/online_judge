package abc238;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean cut[] = new boolean[361];
		cut[0] = cut[360] = true;
		
		int n = sc.nextInt();
		
		int current = 0;
		for(int i = 0; i < n; i++) {
			int tmp = (current + sc.nextInt())%360;
			
			cut[tmp] = true;
			
			current = tmp;
		}
		
		int result = 0;
		int prev = 0;
		for(int i = 1; i <= 360; i++) {
			if(cut[i]) {
				result = Math.max(result, i - prev);
				prev = i;
			}
		}
		
		System.out.println(result);
	}
}

