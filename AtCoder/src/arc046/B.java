package arc046;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);


		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		boolean aWin;

		//問答無用でAが勝つ
		if(a >= n){
			aWin = true;
		}
		else {
			if(a == b){
				//a == bでnが(a+1)の倍数のとき、BからすればAが絶対に1ターンで取り切れない状況に持ち込める
				if(n % (a + 1) == 0){
					aWin = false;
				}
				//上と逆の立場に持ち込める
				else {
					aWin = true;
				}
			}
			//必ずAがラストになるように誘導できる
			else if(a > b){
				aWin = true;
			}
			//上記の逆
			else {
				aWin = false;
			}
		}

		System.out.println(aWin ? "Takahashi" : "Aoki");
	}
}