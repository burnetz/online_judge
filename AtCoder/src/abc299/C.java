package abc299;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] strArray = new String[2];
		strArray[0] = sc.next();
		strArray[1] = new StringBuffer(strArray[0]).reverse().toString();
		
		int result = -1;
		for(int i = 0; i < 2; i++) {
			String str = strArray[i];
			for(int j = 1; j < n; j++) {
				if(str.charAt(j - 1) == '-' && str.charAt(j) == 'o') {
					int count = 0;
					
					for(int k = j ; k < n; k++) {
						if(str.charAt(k) == 'o') {
							count++;
						}
						else {
							j = k;
							break;
						}
					}
					result = Math.max(result, count);
				}
			}
		}
		
		System.out.println(result);
	}
}