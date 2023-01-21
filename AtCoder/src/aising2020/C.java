package aising2020;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= n; i++) {
			int count = 0;
			for(int x = 1; x <= 100 ; x++) {
				if(x*x + 1 + 1 + x + 1 + x > i) {
					break;
				}
				for(int y = 1; y <= 100; y++) {
					if(x*x + y*y + x*y + x + y > i) {
						break;
					}
					for(int z = 1; z <= 100; z++) {
						if(x*x + y*y + z*z + x*y + y*z + z*x == i) {
							count++;
						}
						
						if(x*x + y*y + z*z + x*y + y*z + z*x > i) {
							break;
						}
					}
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.print(sb);
		
	}

}
