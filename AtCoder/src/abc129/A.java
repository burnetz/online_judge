package abc129;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int q = sc.nextInt();
		int r = sc.nextInt();

		System.out.println(p + q + r - Math.max(p, Math.max(q, r)));
	}

}
