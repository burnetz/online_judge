package arc121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int x[] = new int[n];
		int y[] = new int[n];
		int xcopy[] = new int[n];
		int ycopy[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			xcopy[i] = x[i];
			ycopy[i] = y[i];
		}
		
		Arrays.parallelSort(xcopy);
		Arrays.parallelSort(ycopy);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//まともに全ての組み合わせを調べると間に合わない。
		//しかし正しい答えはx方向とy方向それぞれについて
		//最も遠いor2番目に遠い組み合わせのうちのいずれか。
		//これらは事前にソートしておけば該当するインデックスをすぐに全部調べられる
		for(int i = 0; i < n; i++) {
			//ただし横に最も遠い点と縦に最も遠い点が同じ可能性もあるので重複登録には気をつける
			if(!list.contains(i) && (x[i] == xcopy[0] || x[i] == xcopy[1] || x[i] == xcopy[n - 1] || x[i] == xcopy[n - 2] 
					|| y[i] == ycopy[0] || y[i] == ycopy[1] || y[i] == ycopy[n - 1] || y[i] == ycopy[n - 2])){
				list.add(i);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				result.add(Math.max(Math.abs(x[list.get(i)] - x[list.get(j)]), Math.abs(y[list.get(i)] - y[list.get(j)])));
			}
		}
		Collections.sort(result);
		System.out.println(result.get(result.size() - 2));
	}
}