package agc015;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int n = str.length();
		long sum = 0;
		for(int i = 1; i <= n; i++){
			if(str.charAt(i - 1) == 'U'){
				sum += n - i;
				sum += (i - 1)*2;
			}
			else {
				sum += i - 1;
				sum += (n - i)*2;
			}
		}

		System.out.println(sum);
	}
}
