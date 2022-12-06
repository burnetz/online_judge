package abc280;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long k = sc.nextLong();
		
		long divisor = 2;
		long result = 0;
		//素因数分解を行いながら解を求める
		while(k > 1) {
			int count = 0;
			
			while(k % divisor == 0) {
				k /= divisor;
				count++;
			}
			
			//例えばkがa^nを含んでいた場合、aの倍数を並べて
			//含まれるaの数がn個を超えるところが最低条件。
			long tmp = 1;
			while(count > 0) {
				result = Math.max(divisor * tmp, result);
				//ある倍数に含まれるdivisorの数が1とは限らないので数える。
				for(int i = 1; ; i++) {
					if(divisor * tmp % Math.pow(divisor, i) != 0) {
						count -= i - 1;
						break;
					}
				}
				tmp++;
			}
			divisor++;
			//ここまで大きくなっても割れないならこの時点のkは素数。
			if(divisor >= 1_000_001) {
				result = Math.max(k, result);
				break;
			}
		}
		
		System.out.println(result);
	}
}