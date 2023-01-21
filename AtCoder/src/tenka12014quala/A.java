package tenka12014quala;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String array[] = new String[1000];
		
		for(int i = 1; i <= 1000; i++) {
			array[i - 1] = Integer.toString(i);
		}
		
		Arrays.sort(array);
		
		for(int i = 0; i < 1000; i++) {
			System.out.println(array[i]);
		}
	}

}
