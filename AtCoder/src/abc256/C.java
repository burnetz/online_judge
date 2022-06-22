package abc256;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			h[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 3; i++) {
			w[i] = sc.nextInt();
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	static int h[] = new int[3];
	static int w[] = new int[3];
	static int result = 0;
	static int a[][] = new int[3][3];
	
	//適切に枝刈りをすればDFSで間に合う。
	static void dfs(int depth) {
		if(!isValid(depth)) {
			return;
		}
		
		//ここまで来たということはOKな配置であるということ
		if(depth == 9) {
			result++;
			return;
		}
		//30パターンとりあえず仮置きする
		for(int i = 1; i <= 30; i++) {
			a[depth/3][depth%3] = i;
			
			dfs(depth + 1);
		}
	}
	
	//深さに応じて適切なバリデーションを行う。
	static boolean isValid(int level) {
		//行に関するバリデーション
		for(int i = 0; i < 3; i++) {
			if(level >= (i + 1)*3) {
				int sum = 0;
				for(int j = 0; j < 3; j++) {
					sum += a[i][j];
				}
				
				if(sum != h[i]) {
					return false;
				}
			}
		}
		//列に関するバリデーション
		for(int i = 0; i < 3; i++) {
			if(level >= i + 7) {
				int sum = 0;
				for(int j = 0; j < 3; j++) {
					sum += a[j][i];
				}
				
				if(sum != w[i]) {
					return false;
				}
			}
		}
		
		return true;

	}
}
