package agc005;

import java.util.Scanner;
import java.util.Stack;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		Stack<Character> stack = new Stack<Character>();

		//スタックで考えればよい
		//Sはともかく処理に使われなかったTは今後絶対に使わないので考えなくて良い
		int pair = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);

			if(!stack.isEmpty() && c == 'T'){
				stack.pop();
				pair++;
			}
			else if(c == 'S'){
				stack.push(c);
			}
		}

		System.out.println(str.length() - pair*2);
	}

}
