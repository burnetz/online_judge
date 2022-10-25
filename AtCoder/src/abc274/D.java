package abc274;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

 		int n = sc.nextInt();
 		int x = sc.nextInt();
 		int y = sc.nextInt();
 		
 		int offset = 10000;
 		
 		//1回あたりの移動距離が小さいのでDPテーブルを作成できる。
 		//ただし履歴を全て残すと10^8になり流石に大きいので直前の履歴しか残さない。
 		
 		//必ず垂直に移動するのでx方向とy方向別に管理する
 		boolean dpx[][] = new boolean[2][200002];
 		boolean dpy[][] = new boolean[2][200002];
 		
 		int first = sc.nextInt();

 		dpx[0][offset + first] = true;
 		dpy[0][offset] = true;
 		
 		//一応10^8程度の計算回数なので間に合う
 		for(int i = 0; i < n - 1; i++) {
 			
 			int a = sc.nextInt();
 			
 			if(i%2 == 1) {
 				for(int j = a; j < dpx[0].length - a; j++) {
 					if(dpx[0][j]) {
 						dpx[1][j - a] = dpx[1][j + a] = true;
 					}
 				}
 				
 				for(int j = 0; j < dpx[0].length; j++) {
 					dpx[0][j] = dpx[1][j];
 				}
 	 			Arrays.fill(dpx[1], false);
 			}
 			else {
 				for(int j = a; j < dpy[0].length - a; j++) {
 					if(dpy[0][j]) {
 						dpy[1][j - a] = dpy[1][j + a] = true;
 					}
 				}
 				for(int j = 0; j < dpy[0].length; j++) {
 					dpy[0][j] = dpy[1][j];
 				}

 				Arrays.fill(dpy[1], false);

 			}
 		}
 		
 		if(dpx[0][x + offset] && dpy[0][y + offset]) {
 			System.out.println("Yes");
 		}
 		else {
 			System.out.println("No");
 		}
	}
}