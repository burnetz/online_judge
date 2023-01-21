package sumitb2019;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int mod = 1000000007;
		
		int count[] = new int[100001];
		
		long result = 1;
		
		//前提として、どの色も勝手に数字が飛ぶことはない。
		//n人目の前には必ず同じ色のn - 1人目が質問に答えている。
		for(int i = 0; i < n; i++) {
			if(count[a[i]] == 3) {
				System.out.println(0);
				return;
			}
			//自分と同じ色が一人もいない場合は既に何回0が出たかだけでパターンが決まる
			if(a[i] == 0) {
				result *= 3 - count[a[i]];
			}
			//それ以外はa[i]の登場回数およびa[i] - 1の登場回数を総合して考える。
			//場合によってはここで矛盾が生じる。
			else {
				result *= Math.max(count[a[i] - 1] - count[a[i]], 0);
			}
			result %= mod;
			
			count[a[i]]++;
			
		}
		
		System.out.println(result);
	}

}
