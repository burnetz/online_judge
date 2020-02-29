package abc144;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 1; i <= 9; i++){
			if(n%i == 0 && n/i <= 9){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
