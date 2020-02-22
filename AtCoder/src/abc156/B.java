package abc156;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int count = 1;

		while(n >= Math.pow(k, count)){
			count++;
		}

		System.out.println(count);
	}

}
