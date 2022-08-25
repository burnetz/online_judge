package abc265;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long p = sc.nextLong();
		long q = sc.nextLong();
		long r = sc.nextLong();
		
		long a[] = new long[n + 1];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		int rangeP[] = new int[n];
		Arrays.fill(rangeP, -1);
		
		int left = 0;
		int right = 1;
		long sum = a[0];
		//どの区間も尺取り法でならO(N)で該当する区間を全て見つけられる。
		//Pに相当する区間だけは後で順にアクセスするので配列を使い
		//他はHashMapを使えば全部でO(N)でできる
		while(left < n && right < n + 1) {
			if(sum == p) {
				rangeP[left] = right;
			}
			
			if(sum >= p) {
				sum -= a[left];
				left++;
			}
			else {
				sum += a[right];
				right++;
			}
		}
		
		HashMap<Integer, Integer> rangeQ = new HashMap<Integer, Integer>();
		left = 0;
		right = 1;
		sum = a[0];
		while(left < n && right < n + 1) {
			if(sum == q) {
				rangeQ.put(left, right);
			}
			
			if(sum >= q) {
				sum -= a[left];
				left++;
			}
			else {
				sum += a[right];
				right++;
			}
		}
		
		HashMap<Integer, Integer> rangeR = new HashMap<Integer, Integer>();
		left = 0;
		right = 1;
		sum = a[0];
		while(left < n && right < n + 1) {
			if(sum == r) {
				rangeR.put(left, right);
			}
			
			if(sum >= r) {
				sum -= a[left];
				left++;
			}
			else {
				sum += a[right];
				right++;
			}
		}
		
		for(int i = 0; i < n - 2; i++) {
			if(rangeP[i] >= 0) {
				int y = rangeP[i];
				
				if(rangeQ.containsKey(y)) {
					int z = rangeQ.get(y);
					
					if(rangeR.containsKey(z)){
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		
		System.out.println("No");
	}
}