package abc144;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a <= 9 && b <= 9){
			System.out.println(a*b);
		}
		else {
			System.out.println(-1);
		}

	}

}
