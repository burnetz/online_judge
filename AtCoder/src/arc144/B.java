package arc144;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		long num[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextLong();
		}
		
		long low = 0;
		long high = 1_000_000_000 + 1;
		long mid;
		
		//minをmid以上にできるかを2分探索で検証して最大化する。
		//O(N log(Amax))なので間に合う
		while(low + 1< high) {
			mid = (high + low)/2;
			
			boolean possible = true;
			//何をどこに移すかを考えなくても
			//減らせる回数と増やすべき回数の比較で判断することができる。
			long extra = 0;
			long shortage = 0;
			for(int i = 0; i < n; i++) {
				if(num[i] >= mid) {
					extra += (num[i] - mid)/b;
				}
				else {
					shortage += Math.ceil(((double)mid - num[i])/a);
				}
			}
			
			if(shortage > extra) {
				possible = false;
			}
			
			if(possible) {
				low = mid;
			}
			else {
				high = mid;
			}
		}
		
		System.out.println(low);
		
	}

}