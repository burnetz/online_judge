package codefes2014quala;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int a4 = a/4;
		int b4 = b/4;
		int a100 = a/100;
		int b100 = b/100;
		int a400 = a/400;
		int b400 = b/400;
		
		//aとbの間に節目の年が何回あったかはこれで計算できる
		int result = (b4 - a4) - (b100 - a100) + (b400 - a400);
		//ただしa自体が節目の年の場合は調整が必要
		if(a % 4 == 0) {
			result++;
		}
		if(a % 100 == 0) {
			result--;
		}
		if(a % 400 == 0) {
			result++;
		}
		System.out.println(result);
	}

}
