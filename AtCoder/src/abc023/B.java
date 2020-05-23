package abc023;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();

		int steps = (n - 1)/2;

		if(n % 2 == 0 ||  s.charAt(steps) != 'b'){
			System.out.println(-1);
			return;
		}

		String acb = "acb";
		String cab = "cab";
		for(int i = 0; i < steps ; i++){
			if((s.charAt(steps - i - 1) != acb.charAt(i%3)) ||
					(s.charAt(steps + i + 1) != cab.charAt(i%3)) ){
				System.out.println(-1);
				return;
			}
		}

		System.out.println(steps);
	}
}