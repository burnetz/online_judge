package abc173;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int mod = 1_000_000_007;

		Integer a[] = new Integer[n];
		Vector<Integer> posZero = new Vector<Integer>();
		Vector<Integer> neg = new Vector<Integer>();

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			if(a[i] < 0){
				neg.add(a[i]);
			}
			else{
				posZero.add(a[i]);
			}
		}

		//n==kなら全部掛けるだけ
		if(n == k){
			long result = 1;

			for(int i = 0; i < n; i++){
				if(a[i] >= 0){
					result = result * a[i] % mod;
				}
				else {
					result = result * (a[i] + mod)%mod;
				}
			}

			System.out.println(result);
			return;
		}

		//非負の要素だけの配列
		Collections.sort(posZero, new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				// TODO 自動生成されたメソッド・スタブ
				return Math.abs(n2) - Math.abs(n1);
			}
		});

		//負の要素だけの配列。いずれも絶対値で降順にソート
		Collections.sort(neg, new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				// TODO 自動生成されたメソッド・スタブ
				return Math.abs(n2) - Math.abs(n1);
			}
		});

		//全部負でkが奇数なら答えが負にしかならないので絶対値が小さい順に掛ける
		if(neg.size() == n && k%2 == 1){
			long result = 1;
			for(int i = 0; i < k; i++){
				result = result * (neg.get(n - i - 1) + mod)%mod;
			}

			System.out.println(result);
			return;
		}

		long result = 1;
		int posIndex = 0;
		int negIndex = 0;
		//ここまで来たということは必ず答えを非負にできるので
		//非負を維持したまま最大化する
		for(int i = 0; i < k; i++){
			//あと1回なら必ず非負から選ぶ。負から2個選べないときも同様
			if(i == k - 1 || negIndex >= neg.size() - 1){
				result = result*posZero.get(posIndex)%mod;
				posIndex++;
			}
			//非負から選べないときは負を2個掛ける（答えが非負と分かっているのでこの場合必ず負が2つ以上ある）
			else if(posIndex >= posZero.size() - 1){
				result = result*(neg.get(negIndex) + mod)%mod*(neg.get(negIndex + 1) + mod)%mod;
				negIndex += 2;
				i++;
			}
			//それ以外は連続する要素を掛けて比較
			//負は必ず2つずつ選ぶ
			else {
				long tmp1 = (long)posZero.get(posIndex)*posZero.get(posIndex + 1);
				long tmp2 = (long)neg.get(negIndex)*neg.get(negIndex + 1);

				if(tmp1 > tmp2){
					result = result*posZero.get(posIndex)%mod;
					posIndex++;
				}
				else {
					result = result*(neg.get(negIndex) + mod)%mod*(neg.get(negIndex + 1) + mod)%mod;
					negIndex += 2;
					i++;
				}
			}

		}

		System.out.println(result);
	}

}
