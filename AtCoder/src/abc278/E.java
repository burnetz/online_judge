package abc278;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int a[][] = new int[H][W];
		int count[] = new int[n + 1];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i <= H - h; i++) {
			//開始行が変わるたびに初期化。十分間に合う。
			Arrays.fill(count, 0);
			for(int j = 0; j < H; j++) {
				for(int k = 0; k < W; k++) {
					count[a[j][k]]++;
				}
			}
			for(int j = i; j < i + h; j++) {
				for(int k = 0; k < w; k++) {
					count[a[j][k]]--;
				}
			}
			
			//毎回長方形のすべてのマスをチェックすることはできないため
			//それぞれ左端の列と右端の列について更新を行う。
			for(int j = 0; j <= W- w; j++) {
				if(j >= 1) {
					for(int k = i; k < i + h; k++) {
						count[a[k][j - 1]]++;
						count[a[k][j + w - 1]]--;
					}
				}
				System.out.print(countNotZero(count) + " ");
			}
			System.out.println();
		}
	}
	
	static int countNotZero(int a[]) {
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > 0) {
				count++;
			}
		}
		
		return count;
	}
}