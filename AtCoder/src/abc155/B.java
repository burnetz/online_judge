package abc155;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int input[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
	
		for(int i = 0; i < n; i++) {
			if(input[i]%2 == 0 && input[i]%3 != 0 && input[i]%5 != 0) {
				System.out.println("DENIED");
				return;
			}
		}
		
		System.out.println("APPROVED");
	}

}
