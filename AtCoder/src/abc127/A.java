package abc127;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int result = b;
		if(a <= 5){
			result = 0;
		}
		else if( a <= 12){
			result = b/2;
		}

		System.out.println(result);
	}

}
