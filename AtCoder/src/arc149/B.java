package arc149;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Pair[] pairs = new Pair[n];
		
		for(int i = 0; i < n; i++) {
			pairs[i] = new Pair(sc.nextInt(), 0);
		}
		
		for(int i = 0; i < n; i++) {
			pairs[i].b = sc.nextInt();
		}

		//直感的には答えは必ずn以上になる。
		//Anについて完全にソートするだけでnは保証されるため。
		Arrays.sort(pairs);
		
		//そこでAnは既にソートされているものとして
		//そのときのBnにおけるLISを求める。
		int dp[] = new int[n];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = pairs[0].b;
		for(int i = 1; i < n; i++) {
			int index = Arrays.binarySearch(dp, pairs[i].b);
			//今回は同じ数字は出てこないので必ず探索に失敗する。
			//その前提で挿入ポイントを決める。
			index++;
			index *= -1;
			dp[index] = pairs[i].b;
			
		}
		
		//Anの時点で予めn以上であることが確定
		int result = n;
		for(int i = n - 1; i >= 0; i--) {
			if(dp[i] != Integer.MAX_VALUE) {
				result += i + 1;
				break;
			}
		}
		
		System.out.println(result);
	}

}

class Pair implements Comparable<Pair> {

	int a;
	int b;
	
	Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair p) {
		// TODO Auto-generated method stub
		return this.a == p.a ? this.b - p.b : this.a - p.a;
	}
	
}