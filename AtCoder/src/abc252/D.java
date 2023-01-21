package abc252;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//ソートをかけても結果は変わらない。
		//更には各数字が何回出てくるかさえ分かれば良い。
		Arrays.sort(a);
		Vector<Integer> vec = new Vector<Integer>();
		
		int tmp = 1;
		//各数字の出現回数カウント
		for(int i = 0; i < n; i++) {
			if(i != 0 && a[i] == a[i - 1]) {
				tmp++;
			}
			if(i > 0 && a[i] != a[i - 1]) {
				vec.add(tmp);
				tmp = 1;
			}
			
			if(i == n - 1) {
				vec.add(tmp);
			}
		}
		
		//理屈としては3重ループで解くことができるが
		//時間がかかりすぎるので累積和を使って高速化する。
		long sum[] = new long[vec.size() + 1];
		
		for(int i = vec.size() - 1; i >= 0; i--) {
			sum[i] = vec.elementAt(i) + sum[i + 1]; 
		}
		
		long sum2[] = new long[vec.size() + 1];
		
		for(int i = vec.size() - 2; i >= 0 ; i--) {
			sum2[i] = vec.elementAt(i)*sum[i + 1] + sum2[i + 1];
		}
		
		long result = 0;
		for(int i = 0; i < vec.size() - 2; i++) {
			result += vec.elementAt(i)*sum2[i + 1];
		}
		
		System.out.println(result);
	}
}