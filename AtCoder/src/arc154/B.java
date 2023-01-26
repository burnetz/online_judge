package arc154;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] strA = sc.next().toCharArray();
		char[] strB = sc.next().toCharArray();
		
		char[] copyA = strA.clone();
		char[] copyB = strB.clone();
		
		Arrays.sort(copyA);
		Arrays.sort(copyB);
		
		//ソートした結果が一致しない場合は不可能。
		//逆にそれ以外の場合であれば必ずn回以下で可能。
		for(int i = 0; i < n; i++) {
			if(copyA[i] != copyB[i]) {
				System.out.println(-1);
				return;
			}
		}
		
		int result = n;
		int current = n - 1;
		
		//例えば操作をk回行う場合は先頭のk文字をk+1文字目以降に自由に挿入できるということなので
		//k+1文字目以降が文字列Tの部分文字列になっていれば可。
		//末尾から調べればO(N)で判定可能。
		for(int i = n - 1; i >= 0; i--) {
			while(current >= 0) {
				if(strB[current] == strA[i]) {
					current--;
					result--;
					break;
				}
				current--;
			}
		}
		
		System.out.println(result);
	}
}