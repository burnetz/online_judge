package abc144;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long minSteps = Long.MAX_VALUE;
		for(int i = 1; i <= Math.sqrt(n); i++){
			if(n%i != 0){
				continue;
			}

			long tmp = n/i + i - 2;

			if(minSteps > tmp){
				minSteps = tmp;
			}
		}

		System.out.println(minSteps);
	}

}
