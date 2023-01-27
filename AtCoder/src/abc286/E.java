package abc286;

import java.util.Arrays;
import java.util.Scanner;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long item[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			item[i] = sc.nextLong();
		}
		
		boolean path[][] = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] str = sc.next().toCharArray();
			
			for(int j = 0; j < n; j++) {
				if(str[j] == 'Y') {
					path[i][j] = true;
				}
			}
		}
		
		//各i,jに対して最適な総額と距離を保存する。
		long dpValue[][] = new long[n][n];
		long dpTime[][] = new long[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dpValue[i], -1_000_000_000_000_000L);
			dpValue[i][i] = item[i];
			//距離の上下はn
			Arrays.fill(dpTime[i], Integer.MAX_VALUE);
			dpTime[i][i] = 0;
		}
		
		//1ターンで移動できるパターンについて初期化
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(path[i][j]) {
					dpTime[i][j] = 1;
					dpValue[i][j] = item[i] + item[j];
				}
			}
		}
		
		//ワーシャルフロイドと似たような考え方で解く。O(N^3)
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(dpTime[i][k] == Integer.MAX_VALUE || dpTime[k][j] == Integer.MAX_VALUE){
						continue;
					}
					
					//総額の更新が行われるには少なくとも距離が長くならないことが必要。
					if(dpTime[i][j] >= dpTime[i][k] + dpTime[k][j]) {
						boolean equal = dpTime[i][j] == dpTime[i][k] + dpTime[k][j];
						dpTime[i][j] = dpTime[i][k] + dpTime[k][j];
						//距離が短くなる場合は必ず総額を更新する。
						if(!equal) {
							dpValue[i][j] = dpValue[i][k] + dpValue[k][j] - item[k];
						}
						//距離の変化が無いなら総額はより高い方を選ぶ。
						else {
							dpValue[i][j] = Math.max(dpValue[i][j], dpValue[i][k] + dpValue[k][j] - item[k]);
						}
					}					
				}
			}
		}
		
		int q = sc.nextInt();
		
		for(int i = 0; i < q; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			if(dpTime[u][v] > n) {
				System.out.println("Impossible");
			}
			else {
				System.out.println(dpTime[u][v] + " " + dpValue[u][v]);
			}
		}
	}		
}

class Data {
	int from;
	int to;
	int time;
	
	Data (int from, int to, int time){
		this.from = from;
		this.to = to;
		this.time = time;
	}
}