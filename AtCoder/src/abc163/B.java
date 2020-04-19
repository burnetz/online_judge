package abc163;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);


		int n = sc.nextInt();
		int m = sc.nextInt();

		long total  = 0;

		for(int i = 0; i < m ; i++){
			total += sc.nextLong();
		}

		System.out.println(Math.max(-1, n - total));
	}

}
