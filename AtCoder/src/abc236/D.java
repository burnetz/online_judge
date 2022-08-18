package abc236;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		matrix = new long[n*2][n*2];
		
		isUsedComb = new boolean[n*2];
		vecComb = new Vector<Integer[]>();
		
		isUsedPerm = new boolean[n*2];
		num = new int[n];
		vecPerm = new Vector<Integer[]>();
		
		for(int i = 0; i < n*2; i++) {
			for(int j = i + 1; j < n*2; j++) {
				matrix[i][j] = sc.nextLong();
			}
		}
		
		if(n == 1) {
			System.out.println(matrix[0][1]);
			return;
		}
		
		Integer combSeed[] = new Integer[n * 2 - 1];
		for(int i = 0; i < combSeed.length; i++) {
			combSeed[i] = i + 1	;
		}
		dfsComb(combSeed, n - 1, 0, 0);
		dfsPerm(0, n, n);

		long result = 0;
		
		Iterator<Integer[]> itComb = vecComb.iterator();
		
		int women[];
		
		//男女を組ませる（男のほうが必ずIDが小さいものとする）と考えると
		//ID0以外のN-1人の男を選ぶ方法が(2N - 1) C (N-1)<7000,
		//各組み合わせについて女N人の順列がN P N<=50000程度なので
		//効率よく計算すれば一応間に合う。
		while(itComb.hasNext()) {
			Integer[] tmp = itComb.next();
			int[] men = new int[n];
			boolean isMen[] = new boolean[n*2];
			
			isMen[0] = true;
			for(int j = 1; j < n; j++) {
				men[j] = tmp[j - 1];
				isMen[men[j]] = true;
			}
			
			int menCount = 0;
			int womenCount = 0;
			women = new int[n];
			int tmpIndex = 0;
			boolean valid = true;
			
			for(int j = 0; j < 2*n; j++) {
				if(!isMen[j]) {
					women[tmpIndex++] = j;
					womenCount++;
				}
				else {
					menCount++;
				}
				
				//男の方がIDが小さいという仮定で考えているので
				//この分岐に該当する場合マッチング不可の女がいる
				if(menCount < womenCount) {
					valid = false;
					break;
				}
			}
			if(!valid) {
				continue;
			}
			
			Iterator<Integer[]> itPerm = vecPerm.iterator();
			while(itPerm.hasNext()) {
				long tmpResult = 0;
				boolean success = true;
				Integer tmpPerm[] = itPerm.next();
				
				for(int k = 0; k < n; k++) {
					int womanId = women[tmpPerm[k]];
					
					if(men[k] >= womanId) {
						success = false;
						break;
					}
					
					tmpResult ^= matrix[men[k]][womanId];
				}
				
				if(success) {
					result = Math.max(result, tmpResult);
				}
			}
		}
		
		System.out.println(result);
	}
	
	static long matrix[][];
	
	static boolean[] isUsedComb;
	static Vector<Integer[]> vecComb;

	//dfsですべての組み合わせを当たっていく
	//array 問題で必要なデータを与える（普通はきっと長さn） m そのまま depth 現在の階層（今見ているインデックス） count（既に使った色数）
	//最初に実行するときはdepthとcountは0にする
	static void dfsComb(Integer[] array, int m, int depth, int count){
		isUsedComb[depth] = true;
		count++;

		if(count == m){
			Integer[] tmpResult = new Integer[m];
			int tmpIndex = 0;
			for(int i = 0; i < isUsedComb.length; i++) {
				if(isUsedComb[i]) {
					tmpResult[tmpIndex] = array[i];
					tmpIndex++;
				}
			}
			vecComb.add(tmpResult);
		}
		else if(depth != array.length - 1){
			dfsComb(array, m, depth + 1, count);
		}

		isUsedComb[depth] = false;
		count--;
		if(depth != array.length - 1){
			dfsComb(array, m, depth + 1, count);
		}
	}
	
	static boolean isUsedPerm[];
	static int num[];
	static Vector<Integer[]> vecPerm;
	
	//nPmを列挙するためのDFS
	static void dfsPerm(int depth, int n, int m) {
		if(depth == m) {
			Integer tmp[] = new Integer[m];
			
			for(int i = 0; i < m; i++) {
				tmp[i] = num[i];
			}
			
			vecPerm.add(tmp);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!isUsedPerm[i]) {
				isUsedPerm[i] = true;
				num[depth] = i;
				
				dfsPerm(depth + 1, n, m);
				
				isUsedPerm[i] = false;
			}
		}
	}
}
