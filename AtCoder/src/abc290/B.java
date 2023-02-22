package abc290;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		char[] str = sc.next().toCharArray();

		int count = 0;
		for(int i = 0; i < n; i++) {
			if(str[i] == 'o') {
				count++;
			}
			
			if(count > k) {
				str[i] = 'x';
			}
		}
		
		System.out.println(str);
	}
}
