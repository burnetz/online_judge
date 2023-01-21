package abc285;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		int n = str.length;
		
		long result = (long)26*((long)Math.pow(26, n - 1) - 1)/25;
//		System.out.println(result);
		
		long geta = 1;
		
		for(int i = n - 1; i >= 0; i--) {
			result += geta*(str[i] - 'A');
			geta *= 26;
//			System.out.println(result);
		}
		
		System.out.println(result + 1);
	}
}

