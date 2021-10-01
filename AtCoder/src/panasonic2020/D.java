package panasonic2020;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		buf = new char[n];
		
		dfs(0, n, 'a');
	}
	
	static char[] buf;
	
	//駄目なパターンを先に考えると、aacのようにb未使用でcを使った場合はaabに置き換えられるので
	//必要に応じて使える文字を1つずつ増やしていく必要がある。
	static void dfs(int currentDepth, int n, char limit) {
		if(currentDepth == n) {
			System.out.println(buf);
			return;
		}
		
		for(char c = 'a' ; c <= limit ; c++) {
			buf[currentDepth] = c;
			//limitに相当する文字を使ったときだけ文字のバリエーションが1つ増える
			dfs(currentDepth + 1, n, (char)Math.max(limit, c + 1));
		}
	}
}
