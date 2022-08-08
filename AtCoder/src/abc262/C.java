package abc262;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		num = new int[m];
		
		dfs(0, m, n);
	}
	
	static int num[];
	static void dfs(int depth, int maxNum, int length) {
		if(depth == length) {
			for(int i = 0; i < length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		int start = depth == 0 ? 1 : num[depth - 1] + 1;
		for(int i = start; i <= maxNum; i++) {
			num[depth] = i;
			dfs(depth + 1, maxNum, length);
		}
	}
}