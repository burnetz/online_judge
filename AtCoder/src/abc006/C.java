package abc006;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//何故か極端なパターンは下のループで検出できない。多分探索がバグってる
		if(n*2 == m){
			System.out.println(n + " 0 0");
			return;
		}
		if(n*4 == m){
			System.out.println("0 0 "+n);
			return;
		}
		for(int k = 0; k*4 <= m; k++){
			//普通にやったら間に合わないので老人と大人の人数は二分探索で求める
			int l = 0;
			int r = n;
			int mid = (l + r) /2;
			while(l + 1< r){
				if(k + mid > n){
					r = mid;
					mid = (l + r)/2;
					continue;
				}

				int tmp = k*4 + mid*3 + (n - k - mid)*2;

				if(tmp == m){
					System.out.println((n - k - mid) + " " + mid + " " + k);
					return;
				}
				else if(tmp > m){
					r = mid;
				}
				else {
					l = mid;
				}
				mid = (l + r)/2;
			}
		}

		System.out.println("-1 -1 -1");
	}
}