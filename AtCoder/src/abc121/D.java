package abc121;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		long mask = 2;
		long result = 0;

		//1桁目だけは下記のループと考え方が異なるので別で計算しておく
		if(a % 2 == 0){
			if((b - a)%4 == 1 || (b - a)%4 == 2){
				result = 1;
			}
			else {
				result = 0;
			}
		}
		else {
			if((b - a)%4 == 0 || (b - a)%4 == 1){
				result = 1;
			}
			else {
				result = 0;
			}
		}

		//ある桁に着目したときに1のブロックや0のブロックがたくさんあるが、
		//間にあるブロック内で連続する1や0は2のべき乗個なので
		//aとbの偶奇に着目すればXORが1と0のどちらになるかを判断できる。
		for(int i = 1; i <= 50; i++){
			long maskedA = a&mask;
			long maskedB = b&mask;

			if(maskedA == 0 && maskedB != 0 && b % 2 == 0){
				result += mask;
			}
			else if(maskedA != 0 && maskedB == 0 && a % 2 == 1){
				result += mask;
			}
			else if(maskedA != 0 && maskedB != 0 && a % 2 == b % 2){
				result += mask;
			}

			mask *= 2;
		}

		System.out.println(result);
	}

}
