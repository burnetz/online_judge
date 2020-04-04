package abc161;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		double total = 0;
		int a[] = new int [n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			total += a[i];
		}

		int count = 0;
		for(int i = 0; i < n; i++){
			if(a[i] >= total/(4*m)){
				count++;
			}
		}

		if(count >= m){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
