package enumeration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//n個のうちm個を選ぶ方法を全列挙するプログラム
//デモでは数字を表示するだけ
public class Combination {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		isUsed = new boolean[n];

		//デモ用データ
		Integer[] array = new Integer[n];
		for(int i = 0; i < n; i++){
			array[i] = i + 1;
		}
		//このデモではただ数字の配列を渡すだけ
		//問題に応じていい感じに変える
		dfs(array, m, 0, 0);

	}

	static boolean[] isUsed;

	//dfsですべての組み合わせを当たっていく
	//array 問題で必要なデータを与える（普通はきっと長さn） m そのまま depth 現在の階層（今見ているインデックス） count（既に使った色数）
	//最初に実行するときはdepthとcountは0にする
	static void dfs(Object[] array, int m, int depth, int count){
		isUsed[depth] = true;
		count++;

		if(count == m){
			printArray(array);
		}
		else if(depth != array.length - 1){
			dfs(array, m, depth + 1, count);
		}

		isUsed[depth] = false;
		count--;
		if(depth != array.length - 1){
			dfs(array, m, depth + 1, count);
		}
	}

	//デモ用
	static void printArray(Object[] array){
		for(int i = 0; i < array.length; i++){
			if(!isUsed[i]){
				continue;
			}

			System.out.print(array[i]+" ");
		}

		System.out.println();

	}
}

