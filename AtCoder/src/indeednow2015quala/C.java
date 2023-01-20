package indeednow2015quala;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count[] = new int[1_000_001];
		int sum[] = new int[1_000_002];
		
		for(int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}
		//0点は参加できないのでいなかったことにする。
		count[0] = 0;
		
		for(int i = count.length - 1; i >= 0; i--) {
			sum[i] = count[i] + sum[i + 1];
		}
		
		//事前に累積和を求めてあるので二分探索で最小のボーダーを求められる。
		int q = sc.nextInt();
		for(int i = 0; i < q; i++) {
			int cap = sc.nextInt();
			
			int left = -1;
			int right = 1_000_001;
			
			while(right - left > 1) {
				int mid = (left + right)/2;
				
				if(sum[mid] <= cap) {
					right = mid;
				}
				else {
//					System.out.println("NG "+mid);
					left = mid;
				}
			}
			
			System.out.println(right);
		}
	}

}
