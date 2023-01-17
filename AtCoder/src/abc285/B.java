package abc285;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		
		char[] str = sc.next().toCharArray();
		
		for(int i = 1; i <= n - 1; i++) {
			int result = 0;
			for(int j = 0; j + i < n ; j++ ) {
				if(str[j] == str[j + i]) {
					break;
				}
				result = j + 1;
			}
			
			System.out.println(result);
		}
	}
}
