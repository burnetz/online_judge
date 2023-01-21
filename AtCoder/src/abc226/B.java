package abc226;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		
		String input[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextLine();
		}
		
		Arrays.sort(input);
		
//		for(int i = 0; i < n; i++) {
//			System.out.println(input[i]);
//		}
		
		int count = 1;
		for(int i = 1; i < n; i++) {
			if(!input[i].equals(input[i - 1])) {
//				System.out.println(input[i] + " != " + input[i - 1]);
				count++;
			}
		}
		
		System.out.println(count);
	}
}

