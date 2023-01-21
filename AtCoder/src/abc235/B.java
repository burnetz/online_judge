package abc235;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = sc.nextInt();
		for(int i = 1; i < n; i++) {
			int tmp = sc.nextInt();
			if(tmp > result) {
				result = tmp;
			}
			else {
				break;
			}
		}
		System.out.println(result);
		
	}
}

