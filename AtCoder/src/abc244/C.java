package abc244;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean used[] = new boolean[2*n + 2];
		
		for(int i = 0; i <= n ; i++) {
			for(int j = 1; j <= 2*n + 1; j++) {
				if(!used[j]) {
					System.out.println(j);
					used[j] = true;
					break;
				}
			}
			
			int tmp = sc.nextInt();
			
			if(tmp == 0) {
				break;
			}
			
			used[tmp] = true;
		}
		
	}
}