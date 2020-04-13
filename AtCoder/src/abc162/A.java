package abc162;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		if(str[0] == '7' || str[1] == '7' || str[2] == '7') {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
