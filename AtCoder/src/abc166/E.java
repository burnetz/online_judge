package abc166;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int a1[] = new int[n + 1];
		int a2[] = new int[n + 1];
		//|i - j| = a_i + a_jより、a_i + i と j - a_j の比較と考えて差し支えない
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			a1[i + 1] = a[i] + i + 1;
			a2[i + 1] = -a[i] + (i + 1);
		}

		//a_i + i と j - a_iのそれぞれの出現回数を記録する
		//最悪でも2*10^5種類しかないのでメモリ的には問題ない
		HashMap<Integer, Integer> set1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> set2 = new HashMap<Integer, Integer>();

		for(int i = 1; i <= n; i++ ){
			if(!set1.containsKey(a1[i])){
				set1.put(a1[i], 1);
			}
			else {
				set1.put(a1[i], set1.get(a1[i]) + 1);
			}

			if(!set2.containsKey(a2[i])){
				set2.put(a2[i], 1);
			}
			else {
				set2.put(a2[i], set2.get(a2[i]) + 1);
			}
		}

		Iterator<Integer> it = set1.keySet().iterator();

		long result = 0;

		while(it.hasNext()){
			int tmp = it.next();

			if(set2.containsKey(tmp)){
				result += (long)set1.get(tmp) * set2.get(tmp);
			}

		}


		System.out.println(result);
	}

}
