package abc267;

import java.util.Arrays;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

		for(int i = 0; i < days.length; i++) {
			if(days[i].equals(s)) {
				System.out.println(5 - i);
			}
		}
	}
}