package abc032;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int input[] = new int[n];

		boolean hasZero = false;
		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
			if(input[i] == 0){
				hasZero = true;
			}
		}

		//0があるなら全部掛けても積は0
		if(hasZero){
			System.out.println(n);
			return;
		}

		int l = -1;
		for(int i = 0; i < n; i++){
			if(input[i] <= k){
				l = i;
				break;
			}
		}

		//すべての数字がkより大きいなら部分列が存在しない
		if(l < 0){
			System.out.println(0);
			return;
		}

		//尺取り法で考える
		int r = l + 1;
		long p = input[l];
		int result = 1;
		while(r < n){
			if(p*input[r] <= k){
				p *= input[r];
				r++;
				result = Math.max(result, r - l);
			}
			//こちらの分岐はよりよい答えにはならないのでresultの評価は不要
			else {
				p /= input[l];
				l++;
			}
		}

		System.out.println(result);

	}
}