package abc162;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long total = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i % 3 != 0 && i % 5 != 0) {
				total += i;
			}
		}
		
		System.out.println(total);
	}

}
