package arc026;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long original = n;

		long sum = 1;
		int i = 2;

		while(n > 1){
			//それぞれのiごとに素数チェックを行えば最悪でもO(sqrt(N))で終わる
			if(i >= Math.sqrt(n)){
				sum *= (Math.pow(n, 2) - 1)/(n - 1);
				break;
			}
			int count = 0;
			while(n % i == 0){
				count++;
				n /= i;
			}
			//ある素数の出現数が分かれば等比数列の和で出せる
			if(count > 0){
				sum *= (Math.pow(i, count + 1) - 1)/(i - 1);
			}

			i++;
		}
		//上記の方法だとNそのものを引く必要がある
		sum -= original;

		if(sum == original){
			System.out.println("Perfect");
		}
		else if(sum <= original){
			System.out.println("Deficient");
		}
		else{
			System.out.println("Abundant");
		}
	}
}