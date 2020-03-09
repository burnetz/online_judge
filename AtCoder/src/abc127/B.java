package abc127;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int d = sc.nextInt();
		int x = sc.nextInt();

		for(int i = 0; i < 10; i++){
			x = r*x - d;
			
			System.out.println(x);
		}
	}

}
