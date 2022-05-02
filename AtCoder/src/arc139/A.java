package arc139;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int t[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
		}

		long prev = 0;
		
		//0...0の左に何を追加すればよいかを2分探索で求める。
		//左に追加する数は必ず下1桁が1であることに注意する。
		for(int i = 0; i < n; i++) {
			long min = -1;
			//オーバーフロー対策を忘れない
			long max = (Long.MAX_VALUE >> (t[i] + 1)) - 1;
			
			while(min + 1 < max) {
				long mid = (min + max)/2;
				
				if(((mid*2 + 1) << t[i]) > prev) {
					max = mid;
				}
				else {
					min = mid;
				}
			}
			
			prev = ((max * 2 + 1) << t[i]);
		}
		
		System.out.println(prev);
	}
	
}