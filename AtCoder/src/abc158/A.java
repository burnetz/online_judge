package abc158;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[] input = sc.next().toCharArray();

		if(input[0] != input[1] || input[1] != input[2]){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
