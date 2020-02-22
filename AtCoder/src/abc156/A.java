package abc156;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();

		if(n >= 10){
			System.out.println(r);
		}
		else {
			System.out.println(r + 100*(10 - n));
		}
	}

}
