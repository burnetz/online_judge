package abc213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];

		//最終的には入力で現れたx座標、y座標しか残らないので
		//実際の座標→何番目の数字かという変換をすればよい。

		//重複の管理が面倒なので一旦HashSetに入れてからlistに移す
		HashSet<Integer> setA = new HashSet<Integer>();
		HashSet<Integer> setB = new HashSet<Integer>();

		for(int i = 0; i < n ; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();

			setA.add(a[i]);
			setB.add(b[i]);
		}

		ArrayList<Integer> listA = new ArrayList<Integer>(setA);
		ArrayList<Integer> listB = new ArrayList<Integer>(setB);

		Collections.sort(listA);
		Collections.sort(listB);

		for(int i = 0; i < n; i++){
			//indexOfを使うと多分間に合わない。
			//mapに移すほうが動作は速いが以下のほうが書くのは楽
			int c = Collections.binarySearch(listA, a[i]) + 1;
			int d = Collections.binarySearch(listB, b[i]) + 1;

			System.out.println(c + " " + d);
		}

	}

}
