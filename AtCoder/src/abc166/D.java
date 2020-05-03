package abc166;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		//まず、A > Bと仮定しても正しい答えは存在するはず
		//因数分解すれば4乗の項があるため、i,jともに1000くらいまで回せば答えはあるはず
		//それ以上大きくしたら因数分解したあとの片方の多項式だけでXを超えてしまう
		for(long i = 1 ; i <= 1000; i++){
			for(long j = -1000; j < i; j++){
				if(Math.pow(i, 5) - Math.pow(j, 5) == x){
					System.out.println(i + " " +j);
					return;
				}
			}
		}
	}

}
