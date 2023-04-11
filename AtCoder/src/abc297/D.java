package abc297;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long count = 0;
		while(a != b) {
			if(a > b) {
				long tmp = a;
				a = b;
				b = tmp;
			}
			
			count += b / a;
			b %= a;
			
			if(b == 0) {
				count--;
				break;
			}
		}
		
		System.out.println(count);
	}

}
