package arc051;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int k = sc.nextInt();
		
		//ユークリッドの互助法の効率が最も落ちるのはフィボナッチ数列のとき
		//回数は1ずつ増える
		int n = 42;
		int fib[] = new int[n];
		fib[0] = 1;
		fib[1] = 1;
		for(int i = 2; i < n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		

		System.out.println(fib[k + 1]+" "+fib[k]);
	}	
}
