package abc182;

import java.util.HashSet;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();

		int lightY[] = new int[n];
		int lightX[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			lightY[i] = sc.nextInt() - 1;
			lightX[i] = sc.nextInt() - 1;
		}
		
		//盤面は大きくないのでブロックの場所は行列で管理可能
		boolean wall[][] = new boolean[h][w];
		
		for(int i = 0; i < m; i++) {
			wall[sc.nextInt() - 1][sc.nextInt() - 1] = true;
		}
		
		int hid[][] = new int[h][w];
		int vid[][] = new int[h][w];

		int tmpId = 1;
		
		//ブロックにぶつかるまでは同じIDという考え方で
		//水平方向・垂直方向それぞれのIDを全てのマスに割り当てる。
		//一意でさえあれば連続な必要はないので下記の実装では雑に割り当てる。
		for(int i = 0; i < h; i++) {
			
			for(int j = 0; j < w; j++) {
				if(wall[i][j]) {
					tmpId++;
				}
				else {
					hid[i][j] = tmpId;
				}
				
			}
			tmpId++;
			
		}
		
		//垂直方向
		tmpId = 1;
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(wall[j][i]) {
					tmpId++;
				}
				else {
					vid[j][i] = tmpId;
				}
				
			}
			tmpId++;
			
		}
		
		//セットを使うことで上記のIDが連番の必要がなくなる
		HashSet<Integer> hSet = new HashSet<Integer>();
		HashSet<Integer> vSet = new HashSet<Integer>();
		
		//ライトについてのループでマス目の走査をしないので十分高速
		for(int i = 0; i < n; i++) {
			hSet.add(hid[lightY[i]][lightX[i]]);
			vSet.add(vid[lightY[i]][lightX[i]]);
		}
		
		int result = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(wall[i][j]) {
					continue;
				}
				
				//同じマスで2回カウントしないよう気をつける
				if(hSet.contains(hid[i][j])) {
					result++;
				}
				
				else if(vSet.contains(vid[i][j])) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
