package abc163;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);


		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n - 1; i++){
			a[sc.nextInt() - 1]++;
		}

		for(int i = 0; i < n; i++){
			System.out.println(a[i]);
		}
	}

}
