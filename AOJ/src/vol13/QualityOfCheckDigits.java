package vol13;

import java.util.Scanner;

public class QualityOfCheckDigits {

	public static void main(String[] args) {

		int[][] table = new int[10][10];

		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				table[i][j] = sc.nextInt();
			}
		}

		int result = 0;
		int[] original = new int[5];
		int[] copy = new int[5];

		//総当りで考える
loop:		for(int i = 0; i <= 9999; i++){
	//originalとcopyの初期化。配列で1桁ずつ管理する
			for(int j = 0; j < 4; j++){
				int tmp = (int)Math.pow(10, j + 1);
				original[3 - j] = (i % tmp)/(tmp/10);
				copy[3 - j] = original[3 - j];
			}

			original[4] = calcCheckDigit(original, table);
			copy[4] = original[4];

			//特定の一桁だけを変える
			int tmpcd;
			for(int j = 0; j < 4; j++){
				for(int k = 1; k <= 9; k++){
					copy[j] = (copy[j] + 1) % 10;
					tmpcd = calcCheckDigit(copy, table);

					//チェックディジットが正しく機能しなかった場合
					if(table[tmpcd][copy[4]] == 0){
						continue loop;
					}
				}
				copy[j] = original[j];
			}

			//最後の一桁だけ違う数字の場合
			tmpcd = calcCheckDigit(copy, table);
			for(int j = 1; j <= 9; j++){
				int tmp = (original[4] + j) % 10;

				//チェックディジットが正しく機能しなかった場合
				if(table[tmpcd][tmp] == 0){

					continue loop;
				}
			}



			//特定の一桁だけを入れ替える
			for(int j = 0; j < 4; j++){
				if(copy[j] == copy[j + 1]){
					continue;
				}
				swap(copy, j, j + 1);

				tmpcd = calcCheckDigit(copy, table);

				//チェックディジットが正しく機能しなかった場合
				if(table[tmpcd][copy[4]] == 0){

					continue loop;
				}

				swap(copy, j, j + 1);
			}

			//誤りを適切に検出できる場合は加算
			result++;
		}

		System.out.println(10000 - result);
	}


	static int calcCheckDigit(int[] array, int[][] table){
		int result = table[0][array[0]];

		for(int i = 1; i < 4; i++){
			result = table[result][array[i]];
		}

		return result;
	}

	static void swap(int[] array, int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

}
