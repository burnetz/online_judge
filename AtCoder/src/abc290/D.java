package abc290;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt() - 1;
			
			//a≡a+d(mod n)と考えて元の位数を求める。
			int order = n/gcd(n, d);
			
			//衝突するたびにoffsetを1増やす。
			//衝突は+dをorder回繰り返したときに発生する。
			int offset = k/order;
			
			int result = (int)(((long)k*d + offset)%n);
			
			System.out.println(result);
		}
	}
	

	static int gcd(int a, int b){
        int tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}