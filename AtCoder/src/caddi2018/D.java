package caddi2018;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		//残りが各色偶数個（0個含む）ずつになった状態で自分の番が来ると負け確なので
		//最初に奇数個のものがあるかどうかで勝敗が決まる。
		for(int i = 0; i < n; i++) {
			if(sc.nextInt()%2 == 1) {
				System.out.println("first");
				return;
			}
		}
		
		System.out.println("second");
	}

}
