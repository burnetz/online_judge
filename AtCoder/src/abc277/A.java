package abc277;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if(tmp == x) {
				System.out.println(i + 1);
				return;
			}
		}
		
	}
}