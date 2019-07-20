package abc134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int input[] = new int[n + 1];

		String[] tmpArray = br.readLine().split(" ");
		for(int i = 1; i <= n; i++){
			input[i] = Integer.parseInt(tmpArray[i - 1]);
		}

		boolean result[] = new boolean[n + 1];

		//実際には条件を満たす数列は1パターンしかない。
		//後ろから決めていけば一意に定まる。
		int count = 0;
		for(int i = n; i >= 1; i--){
			int tmpCount = 0;

			//iの倍数で既にボールを入れた箱がいくつあるか数える（意外と間に合う）
			for(int j = 2; j * i <= n; j++){
				if(result[j * i]){
					tmpCount++;
				}
			}

			//入力で与えられた条件に沿うようにi番目の結果を決める
			if((tmpCount%2 == 0 && input[i] == 1) || (tmpCount%2 == 1 && input[i] == 0)){
				result[i] = true;
				count++;
			}
		}

		System.out.println(count);
		boolean first = true;
		for(int i = 1; i <= n; i++){
			if(result[i]){
				if(first){
					System.out.print(i);
					first = false;
				}
				else{
					System.out.print(" "+i);
				}
			}
		}
		if(count != 0){
			System.out.println();
		}
	}

}