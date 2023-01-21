package abc184;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		
		String str = sc.next();
		
		for(int i = 0; i < n; i++) {
			switch (str.charAt(i)) {
			case 'o':
				x++;
				break;

			default:
				x = Math.max(0, x - 1);
				break;
			}
		}
		
		System.out.println(x);
	}

}
