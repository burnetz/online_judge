package arc146;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		String[] input = new String[n];
		for(int i = 0; i < n; i++) {
			input[i] = sc.next();
		}
		
		Arrays.sort(input, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.length() != s1.length() ? s2.length() - s1.length() : s2.compareTo(s1);
			}
		});
		
		String a = input[0];
		String b = input[1];
		String c = input[2];
		
		long num[] = new long[6];
		num[0] = Long.parseLong(a + b + c);
		num[1] = Long.parseLong(a + c + b);
		num[2] = Long.parseLong(b + a + c);
		num[3] = Long.parseLong(b + c + a);
		num[4] = Long.parseLong(c + a + b);
		num[5] = Long.parseLong(c + b + a);
		
		Arrays.sort(num);
		
		System.out.println(num[5]);
	}

}