package abc119;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		len = new int[n];
		
		for(int i = 0; i < n; i++) {
			len[i] = sc.nextInt();
		}
		
		group = new int[n];
		
		System.out.println(solve(0));
	}
	static int n;
	static int a, b, c;
	static int len[];
	//group[i] : 0->使わない予定 1,2,3->A,B,Cにする予定
	static int group[];

	//最大8本なので全探索可能
	//各魔法の順番は気にしなくてよいのでグループ管理だけしっかりすればよい（4^n）
	static int solve(int depth) {
		if(depth == n) {
			int cost = 0;
			int array[] = new int[4];
			for(int i = 0; i < n; i++) {
				//合成魔法
				if(group[i] != 0 && array[group[i]] != 0) {
					cost += 10;
				}
				
				array[group[i]] += len[i];
			}
			//グループ1~3のいずれかが割当無しの場合は流石に駄目
			if(array[1] == 0 || array[2] == 0 || array[3] == 0) {
				return Integer.MAX_VALUE;
			}
			
			cost += Math.abs(a - array[1]);
			cost += Math.abs(b - array[2]);
			cost += Math.abs(c - array[3]);
			return cost;
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < 4; i++) {
			group[depth] = i;
			result = Math.min(result, solve(depth + 1));
		}
		
		return result;
	}
}
