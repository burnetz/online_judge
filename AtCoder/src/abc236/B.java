package abc236;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count[] = new int[n + 1];
		
		for(int i = 0; i < 4*n - 1; i++) {
			count[sc.nextInt()]++;
		}
		
		for(int i = 1; i <= n; i++) {
			if(count[i] == 3) {
				System.out.println(i);
				return;
			}
		}
		
	}
}

