package apc001;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Pair[] pairs = new Pair[n];
		
		long a[] = new long[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}

		long b[] = new long[n];
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextLong();
		}

		for(int i = 0; i < n; i++) {
			pairs[i] = new Pair(a[i], b[i]);
		}
		
		//aiとbiの差によってソートする。
		Arrays.sort(pairs);
		
		int tail = n - 1;
		
		//ai<=biならi番目だけで条件を満たせるor既に満たしている。
		//ai>biのときはaj<bjであるj番目を選びajとbiを増やす。
		//これを最後までできればクリア、途中までしかできないなら不可能となる。
		//左側のために右側から融通すると考えればO(N)で可能。
		for(int i = 0; i < n; i++) {
			if(pairs[i].a <= pairs[i].b) {
				continue;
			}
			
			for(; tail > i; tail--) {
				//これ以上左に行ってもaに余裕があるところは無い。
				if(pairs[tail].a > pairs[tail].b) {
					System.out.println("No");
					return;
				}
				long require = pairs[i].a - pairs[i].b;
				long supplyMax = (pairs[tail].b - pairs[tail].a)/2;
				
				long supply = Math.min(require, supplyMax);
				
				pairs[i].b += supply;
				pairs[tail].a += supply*2;
				
				//tail番目の端数を次も使うことを考えてbreakで抜ける。
				if(pairs[i].a <= pairs[i].b) {
					break;
				}
			}
			if(pairs[i].a > pairs[i].b) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}

}

class Pair implements Comparable<Pair>{
	long a;
	long b;
	
	Pair(long a, long b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Pair p) {
		// TODO Auto-generated method stub
		long d1 = this.b - this.a;
		long d2 = p.b - p.a;
		
		return d1 == d2 ? 0 : 
			d1 > d2 ? 1 : -1;
	}
	
}
