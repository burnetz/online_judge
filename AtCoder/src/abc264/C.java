package abc264;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h1 = sc.nextInt();
		int w1 = sc.nextInt();
		
		int matA[][] = new int[h1][w1];
		
		for(int i = 0; i < h1; i++) {
			for(int j = 0; j < w1; j++) {
				matA[i][j] = sc.nextInt();
			}
		}

		int h2 = sc.nextInt();
		int w2 = sc.nextInt();
		
		int matB[][] = new int[h1][w1];
		
		for(int i = 0; i < h2; i++) {
			for(int j = 0; j < w2; j++) {
				matB[i][j] = sc.nextInt();
			}
		}

		//2^20はそこまで大きくないので全パターン試すことができる
		for(int i = 0; i <= Math.pow(2, h1 + w1) - 1; i++) {
			int mask = 1;
			Vector<Integer> vecH = new Vector<Integer>();
			Vector<Integer> vecW = new Vector<Integer>();
			
			int tmpH = 0;
			for(int j = 0; j < h1; j++) {
				if((mask & i) != 0) {
					vecH.add(j);
					tmpH++;
				}
				mask <<= 1;
			}
			
			int tmpW = 0;
			for(int j = 0; j < w1; j++) {
				if((mask & i) != 0) {
					vecW.add(j);
					tmpW++;
				}
				mask <<= 1;
			}
			
			if(tmpH != h2 || tmpW != w2) {
				continue;
			}
			
			boolean same = true;
			
			for(int j = 0; j < h2; j++) {
				for(int k = 0; k < w2 ; k++) {
					if(matB[j][k] != matA[vecH.get(j)][vecW.get(k)]) {
						same = false;
						break;
					}
				}
				if(!same) {
					break;
				}
			}
			
			if(same) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
	
}