package vol25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrokenAudioSignal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			int n = Integer.parseInt(br.readLine());

			if(n == 0){
				break;
			}

			//xの値が-10^9～10^9とは言っていないので
			//上限と下限を少し余分に取らないと誤答になる
			int low = -1_000_000_003;
			int high = 1_000_000_003;
			final int x = Integer.MIN_VALUE;

			String[] tmpArray = br.readLine().split(" ");
			int input[] = new int[n];
			for(int i = 0; i < n; i++){
				if(tmpArray[i].equals("x")){
					input[i] = x;
				}
				else {
					input[i] = Integer.parseInt(tmpArray[i]);
				}
			}

			boolean fault = false;
			for(int i = 0; i < n; i++){
				if(input[i] == x){
					//xが2連続は問答無用でアウト
					if(i != n - 1 && input[i + 1] == x){
						fault = true;
						break;
					}

					//両脇より大きくなければならない
					if(i % 2 == 1){
						if(i != n - 1){
							low = Math.max(low, input[i + 1]);
						}
						//奇数なら先頭のわけないので条件省略
						low = Math.max(low, input[i - 1]);
					}
					//両脇より小さくなければならない
					else {
						if(i != n - 1){
							high = Math.min(high, input[i + 1]);
						}
						if(i != 0){
							high = Math.min(high, input[i - 1]);
						}
					}
					continue;
				}

				//ここからは普通の数字が連続している場合

				//上がってないとおかしい
				if(i % 2 == 0){
					if(i != n - 1 && input[i + 1] != x && input[i] >= input[i + 1]){
						fault = true;
						break;
					}
				}
				//下がってないとおかしい
				else {
					if(i != n - 1 && input[i + 1] != x && input[i] <= input[i + 1]){
						fault = true;
						break;
					}
				}
			}

			//完全にアウトな条件を踏んだ場合
			if(fault){
				System.out.println("none");
			}
			//特定が可能なのは差が2のときだけ
			else if(low + 2 == high){
				System.out.println(low + 1);
			}
			//このときはxの値は存在しない
			else if(high - low <= 1){
				System.out.println("none");
			}
			//これ以外のときはxの値を特定できない
			else {
				System.out.println("ambiguous");
			}

		}
	}

}
