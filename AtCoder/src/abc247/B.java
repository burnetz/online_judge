package abc247;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String names[][] = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				String str = sc.next();
				names[i][j] = str;
			}
		}
		
		for(int i = 0; i < n; i++) {
			boolean ok1 = false;
			for(int j = 0; j < 2; j++) {
				boolean ok2 = true;
				for(int k = 0; k < n; k++) {
					if(k == i) {
						continue;
					}
					for(int l = 0; l < 2; l++) {
						if(names[i][j].equals(names[k][l])) {
							ok2 = false;
						}
					}
					
				}
				if(ok2) {
					ok1 = true;
				}
			}
			
			if(!ok1) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}