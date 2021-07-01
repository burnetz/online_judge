package abc192;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		int k = sc.nextInt();

		for(int i = 0; i < k; i++){
			char g2Str[] = Long.toString(n).toCharArray();
			Arrays.sort(g2Str);

			long g1 = Long.parseLong(new StringBuffer(new String(g2Str)).reverse().toString());
			long g2 = Long.parseLong(new String(g2Str));
			n = g1 - g2;
		}

		System.out.println(n);
	}

}
