package abc204;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int sum = 0;

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			sum += a[i];
		}

		HashSet<Integer> set = new HashSet<Integer>();

		set.add(0);

		//i番目までであり得る合計時間の組み合わせを全て記録する。
		//問題の条件からsetの中身は10^5パターンまでしか増えないので間に合う
		for(int i = 0; i < n; i++){
			ArrayList<Integer> list = new ArrayList<Integer>(set);

			Iterator<Integer> it = list.iterator();
			while(it.hasNext()){
				int x = it.next();

				set.add(x + a[i]);
			}
		}

		//あり得る全ての合計時間の中でsumの半分以上かつ最小のものが答え
		for(int i = (sum + 1)/2; i <= sum; i++){
			if(set.contains(i)){
				System.out.println(i);
				return;
			}
		}
	}

}
