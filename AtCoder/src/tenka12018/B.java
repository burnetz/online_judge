package tenka12018;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		int k = sc.nextInt();

		for(int i = 0; i < k; i++){
			if(i % 2 == 0){
				a = a/2*2/2;
				b += a;
			}
			else {
				b = b/2*2/2;
				a += b;
			}
		}

		System.out.println(a + " " + b);
	}

}
