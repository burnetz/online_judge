package abc215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		str = sc.next().toCharArray();
		int k = sc.nextInt();
		index = new int[str.length];
		Arrays.fill(index, -1);

		dfs(0, index.length);

		ArrayList<String> list = new ArrayList<String>(set);

		Collections.sort(list);

		System.out.println(list.get(k - 1));
	}

	static char[] str;
	static int index[];
	static HashSet<String> set = new HashSet<String>();

	static void dfs(int depth, int n){
		if(depth == n){
			char[] tmpStr = new char[n];

			for(int i = 0; i < n; i++){
				tmpStr[index[i]] = str[i];
			}

			set.add(new String(tmpStr));

			return;
		}

		for(int i = 0; i < n; i++){
			if(index[i] == -1){
				index[i] = depth;

				dfs(depth + 1, n);

				index[i] = -1;
			}
		}
	}

}
