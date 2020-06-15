package arc007;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String pattern = sc.next();

		int n = pattern.length();
		boolean watch[] = new boolean[n];

		int result = n;
		//最大10文字なので全探索可能
		for(int i = 1; i <= Math.pow(2, n) - 1; i++){
			Arrays.fill(watch, false);

			int mask = 1;

			int tv = 0;
			for(int j = 0; j < n; j++){
				int tmpMask = mask << j;

				//j分にテレビをつけたと仮定
				if((int)(i & tmpMask) != 0){
					tv++;

					for(int k = 0; k < n; k++){
						if(pattern.charAt(k) == 'o'){
							watch[(j + k)%n] = true;
						}
					}
				}
			}

			//modで考えた結果全部trueで埋まればずっとテレビを観られるということ
			int count = 0;
			for(int j = 0; j < n; j++){
				if(watch[j]){
					count++;
				}
			}

			if(count == n){
				result = Math.min(result, tv);
			}
		}

		System.out.println(result);
	}

}
