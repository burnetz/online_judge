package abc229;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//おそらく邪道。以下の解法では最初がxだった場合に対処できないため
		char[] str = ("."+sc.next()).toCharArray();
		int k = sc.nextInt();
		
		int n = str.length;

		//dots[i]:i文字目までのドットの個数
		int dots[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(i != 0) {
				dots[i] = dots[i - 1];
			}
			
			if(str[i] == '.') {
				dots[i]++;
			}
		}
		
		//自明にすべてxにできるケース
		if(dots[n - 1] <= k) {
			System.out.println(n - 1);
			return;
		}
		
		//lower[i],upper[i]:ドットの個数がi個となるインデックスの下限と上限
		int lower[] = new int[n + 1];
		int upper[] = new int[n + 1];
		
		for(int i = 0; i < n; i++) {
			upper[dots[i]] = i;
		}
		for(int i = n - 1; i >= 0; i--) {
			lower[dots[i]] = i;
		}
		
		int result = 0;
		for(int i = 0; i <= dots[n - 1] ; i++) {
			int right = upper[i];
			int left = lower[Math.max(0, i - k)];
			
			result = Math.max(result, right - left);
		}
		
		System.out.println(Math.min(n - 1, result));
	}
}
