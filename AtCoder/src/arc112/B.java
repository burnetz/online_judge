package arc112;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long b = sc.nextLong();
		long c = sc.nextLong();

		long negU, negL, nonNegU, nonNegL;

		//このパターンは面倒なので別枠（明らかに0しか作れない）
		if(b == 0 && c <= 1){
			System.out.println(1);
			return;
		}

		//非負のある区間内、負のある区間内は全て解なので
		//各区間の上限下限だけを求める
		if(b > 0){
			negU = Math.min(-1, -b + (c - 1)/2);
			negL = -b - (c - 1)/2;
			nonNegU = b + (c - 2)/2;
			nonNegL = Math.max(0, b - c/2);
		}
		else if(b < 0){
			negU = Math.min(-1,b + (c - 2)/2);
			negL = b - c/2;
			nonNegU = -b + (c - 1)/2;
			nonNegL = Math.max(0, -b - (c - 1)/2);
		}
		else {
			negU = -1;
			negL = -1 - (c - 1)/2;
			nonNegU = (c - 1)/2;
			nonNegL = 0;
		}

		System.out.println(negU + nonNegU - negL - nonNegL + 2);
	}
}