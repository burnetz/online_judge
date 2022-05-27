package arc138;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		
		for(int i = 0; i < n ; i++) {
			a[i] = sc.nextInt();
		}
		
		boolean flip = false;
		int left = 0;
		int right = n - 1;
		
		//下のループでは数列が"1"のときに対応できないのでここで処理
		if(n == 1 && a[0] == 1) {
			System.out.println("No");
			return;
		}
		//逆操作で空文字にできるなら構築可能ということ。
		//AとBの逆操作A',B'を考える。
		//末尾から0を取り除くB'は可能なときは即座に行う。
		//B'ができないときはA'を1回試す。これは先頭が0のときしかできないので
		//A'試行前に先頭が1になったら構築不可能ということ。
		//実際に数字を反転させる時間はないのでflipでモードを管理する。
		while(left < right) {
			while((!flip && a[right] == 0) || (flip && a[right] == 1)) {
				right--;
			}
			
			if((!flip && a[left] == 1) || (flip && a[left] == 0)) {
				System.out.println("No");
				return;
			}
			else {
				left++;
				flip = !flip;
			}
		}
		
		System.out.println("Yes");
	}		
}