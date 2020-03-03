package abc131;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int sum = n*(2*l + n - 1)/2;
		
		if(l >= 0) {
			sum -= l;
		}
		else if(l <= -n) {
			sum -= l + n - 1;
		}
		
		System.out.println(sum);
	}

}
