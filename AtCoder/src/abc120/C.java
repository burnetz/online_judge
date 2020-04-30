package abc120;

import java.util.Scanner;
import java.util.Stack;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();

		Stack<Character> stack = new Stack<Character>();

		int count = 0;

		//前から順に見ていくのが最適
		//スタックの先頭と合わせれば取り除ける場合はpop、それ以外はpush
		for(int i = 0; i < str.length; i++){
			if(!stack.isEmpty() && stack.peek() != str[i]){
				stack.pop();
				count++;
			}
			else {
				stack.push(str[i]);
			}
		}

		System.out.println(count*2);
	}
}