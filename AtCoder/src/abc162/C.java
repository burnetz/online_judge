package abc162;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		long total = 0;

		for(int i = 1; i <= k; i++) {
			for(int j = 1; j <= k; j++) {
				for(int l = 1; l <= k; l++) {
					total += gcd(gcd(i,j),l);
				}
			}
		}

		System.out.println(total);
	}

	static int gcd(int a, int b){
		int tmp;

		while (a % b != 0)
		{
			tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

}
