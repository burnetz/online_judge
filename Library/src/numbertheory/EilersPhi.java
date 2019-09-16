package numbertheory;

import java.util.Scanner;

public class EilersPhi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		//n==1は以下の方法では求められないが明らかに0
		if(n == 1){
			System.out.println(0);
		}
		//割る数。素数でなくてもよい（どのみち素数のときしか割れない）
		int divisor = 2;

		long result = 1;

		//オイラーのφ関数は乗法的なので
		//各素数pについてφ(p^k)を求めればその積が答えとなる
		while(n > 1){

			int count = 0;

			//ある素数で何回割れるかを数える
			while(n % divisor == 0){
				count++;
				n /= divisor;
			}

			//φ(p^k)を計算して結果に乗算する
			if(count != 0){
				result *= Math.pow(divisor, count) - Math.pow(divisor, count - 1);
			}

			divisor++;
		}

		System.out.println(result);
	}

}