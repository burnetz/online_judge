package abc167;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		int result = 0;

		result += Math.min(a, k);
		k -= Math.min(a, k);

		if(k > 0){
			k -= Math.min(b, k);
		}

		if(k > 0){
			result -= k;
		}
		System.out.println(result);


	}

}
