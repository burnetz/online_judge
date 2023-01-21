package abc283;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < str.length; i++) {
			if(str[i] == '(') {
				stack.push(str[i]);
			}
			else if(str[i] == ')') {
				while(true) {
					char tmp = stack.pop();
//					System.out.println("pop "+tmp);
					if(tmp == '(') {
						break;
					}
					else {
						set.remove(tmp);
					}
				}
			}
			else {
				if(set.contains(str[i])) {
					System.out.println("No");
					return;
				}
				else {
					stack.push(str[i]);
					set.add(str[i]);
				}
			}
		}
		
		System.out.println("Yes");
	}
}