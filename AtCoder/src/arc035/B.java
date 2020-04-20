package arc035;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int t[] = new int[n];
		int sameTime[] = new int[10001];

		for(int i = 0; i < n; i++){
			t[i] = sc.nextInt();
			sameTime[t[i]]++;
		}

		Arrays.sort(t);

		//所要時間が短い問題から解くのが最も効率が良い
		long total = 0;
		long time = 0;
		for(int i = 0; i < n; i++){
			total += t[i] + time;
			time += t[i];
		}

		//所要時間が同じ問題が複数あればその分だけパターン数が増える
		long pattern = 1;
		int mod = 1_000_000_007;
		for(int i = 0; i < sameTime.length; i++){
			if(sameTime[i] > 0){
				//階乗計算
				for(int j = 2; j <= sameTime[i]; j++){
					pattern *= j;
					pattern %= mod;
				}
			}
		}

		System.out.println(total);
		System.out.println(pattern);
	}
}