package abc162;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		long total = 0;
		
		//colors[i][j]: j文字目より右にiの色が何文字あるか
		int[][] colors = new int[3][n];
		
		for(int i = n - 2; i >= 0; i--) {
			if(str[i + 1] == 'R') {
				colors[0][i]++;
			}
			if(str[i + 1] == 'G') {
				colors[1][i]++;
			}
			if(str[i + 1] == 'B') {
				colors[2][i]++;
			}
			
			for(int j = 0; j < 3; j++) {
				colors[j][i] += colors[j][i + 1];
			}
		}
		
		boolean[] appear = new boolean[3];
		//j番目より右に各色が何回登場するかを既に知っているのでO(N^2)で解ける
		for(int i = 0; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				if(str[i] == str[j]) {
					continue;
				}
				
				//既に出てきた2色が何色かを保存する
				if(str[i] == 'R' || str[j] == 'R') {
					appear[0] = true;
				}
				if(str[i] == 'G' || str[j] == 'G') {
					appear[1] = true;
				}
				if(str[i] == 'B' || str[j] == 'B') {
					appear[2] = true;
				}
				
				for(int k = 0; k < 3; k++) {
					if(!appear[k]) {
						total += colors[k][j];
						
						int dist = j - i;
						
						//左右等間隔で全て異なる色にできてしまうときはそれだけは除外する
						if(j + dist < n && str[i] != str[j + dist] && str[j] != str[j + dist]) {
							total--;
						}
					}
				}
				Arrays.fill(appear, false);
			}
			
			
		}
		
		System.out.println(total);
	}

}
