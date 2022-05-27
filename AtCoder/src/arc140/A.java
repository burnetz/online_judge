package arc140;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		char input[] = sc.next().toCharArray();
		
		int result = n;
		
		//f(S)=iにできるというのは
		//どの文字もi文字後が同じ文字であるということと同値。
		//適切に読み飛ばせばO(N^2)で検証できる。
loop:		for(int i = 1; i <= n; i++) {
			//f(S)=iにするために最低必要な変更回数
			int diff = 0;
			
			boolean[] fixed = new boolean[n];
			
			//S[j]から始まるサイクルを調べる。
			//サイクル内で一番出現回数の多いアルファベットを調べ
			//サイクル中の他の文字もそれに統一するのが最小。
			for(int j = 0; j < n; j++) {
				if(fixed[j]) {
					continue;
				}
				
				fixed[j] = true;
				int index = (j + i)%n;
				int alpha[] = new int[26];
				alpha[input[j] - 'a']++;
				int cycleLen = 1;
				while(!fixed[index]) {
					alpha[input[index] - 'a']++;
					cycleLen++;
					fixed[index] = true;
					index += i;
					index %= n;
				}
				
				Arrays.sort(alpha);
				
				diff += cycleLen - alpha[25];
			}
			
			if(diff <= k) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
}