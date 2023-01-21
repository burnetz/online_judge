package yahooprocon2019qual;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		//b - a <= 2のときは毎ターン叩き続けた方がマシ
		if(b - a <= 2){
			System.out.println(k + 1);
		}
		else{
			int remain = k - (a - 1);
			long result = remain % 2;
			//交換レートが良くてもA枚貯めたあとの残りが2ターン以上ないとビスケットに戻せない
			if(remain >= 2){
				int change = remain / 2;
				//交換によって得られる枚数は等差数列
				result += (b + (long)(change - 1)*(b - a));
			}
			//2ターン余っていないならやはり叩き続けるのが最適
			else {
				result = k + 1;
			}
			System.out.println(result);
		}
	}

}
