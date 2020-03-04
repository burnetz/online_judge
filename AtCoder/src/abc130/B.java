package abc130;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();

		int pos = 0;
		int count = 1;
		for(int i = 0; i < n; i++) {
			pos += sc.nextInt();
			
			if(pos > x) {
				break;
			}
			
			count++;
		}
		
		System.out.println(count);
	}

}
