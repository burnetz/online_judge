package vol27;

import java.util.Scanner;

public class MandA {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[][] strs = new char[2][];
		strs[0] = sc.next().toCharArray();
		strs[1] = sc.next().toCharArray();

		//Sの文字から始まる場合とTの文字から始まる場合がありえる
loop:		for(int i = 0; i <= 1; i++){
			int[] indexes = {0,0};
			int current = i;
			//Sと同じ文字列を作れるかを1文字ずつチェックする
			for(int j = 0; j < strs[0].length; j++){
				//必要な文字が見つかるまで探す
				while(strs[current][indexes[current]] != strs[0][j]){
					indexes[current]++;
					if(indexes[current] == strs[0].length){
						continue loop;
					}
				}
				//以下の処理を入れないと同じ文字が連続する場合に誤判定する
				//ただし最後までループが回った（文字列を作ることができた）場合は抜けない
				indexes[current]++;
				if(indexes[current] == strs[0].length && j != strs[0].length - 1){
					continue loop;
				}
				current = (current + 1) % 2;
			}

			System.out.println("Yes");
			return;
		}

		System.out.println("No");
	}

}
