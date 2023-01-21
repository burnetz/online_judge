package abc216;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		long input[] = new long[n + 1];
		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
		}
		input[n] = 0;

		Arrays.sort(input);

		long result = 0;

		//kが大きすぎるため例えば優先度付きキューなどで忠実にシミュレーションしようとするとTLEになる。
		//ただkを無視すればa[i]+(a[i] - 1)+(a[i] - 2)+...+(a[i - 1] + 1)の総和を求めることでショートカット可能。
		//操作を繰り返す中でa[i]よりも後ろの要素は全てa[i]と同じになったと仮定して計算できる。
		for(int i = n ; i >= 1; i--){
			if(input[i] > input[i - 1]){
				//kが十分に余裕がある場合は上記の解説のとおり
				if(k >= (n - i + 1)*(input[i] - input[i - 1])){
					long b = input[i];
					long a = input[i - 1] + 1;
					result += (b*b - a*a + b + a)/2*(n - i + 1);
					k -= (n - i + 1)*(input[i] - input[i - 1]);
				}
				//kにショートカットできるほどの余裕がない場合はより細くループを回すことで計算する
				//O(k)なのがやや気になるが一応間に合う
				else {
					long x = input[i];
					while (k > 0){
						result += x*Math.min(k, n - i + 1);
						k -= Math.min(k, n - i + 1);
						x--;
					}
				}
			}

			if(k == 0){
				break;
			}
		}


		System.out.println(result);
	}

}
