package abc223;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		String[] array = new String[s.length() + 1];
		array[0] = s;
		for(int i = 1; i <= s.length() ; i++) {
			array[i] = array[i - 1].substring(1) + array[i - 1].charAt(0);
//			System.out.println(array[i]);
		}
		
		Arrays.sort(array);
		
		System.out.println(array[0]);
		System.out.println(array[s.length()]);
		
	}
}

