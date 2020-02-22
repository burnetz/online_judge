package abc149;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		loop:	for(int i = a; i <= Integer.MAX_VALUE ; i++) {
			for(int j = 2; j <= (int)Math.sqrt(i) ; j++) {
				if(i % j == 0) {
					continue loop;
				}
			}
			
			System.out.println(i);
			return;
		}
	}

}
