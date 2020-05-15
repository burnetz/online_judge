package abc048;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();

		long n1;

		if(a % c == 0){
			n1 = Math.max(0, a/c - 1);
		}
		else {
			n1 = a/c;
		}

		long n2 = b/c;

		//倍数の話に0が絡むとややこしいことになる
		long geta = a == 0 ? 1 : 0;

		System.out.println(n2 - n1 + geta);
    }
}