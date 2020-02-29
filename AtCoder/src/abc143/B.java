package abc143;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int d[] = new int[n];
		for(int i = 0; i < n; i++){
			d[i] = sc.nextInt();
		}

		int total = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				total += d[i]*d[j];
			}
		}
		System.out.println(total);
	}

}
