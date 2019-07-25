package vol23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarpentersLanguage {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(br.readLine());

		String[] tmpArray;

		//つまるところ、"("と")"の数さえ合っていればなんだかんだ指定の文法に合致する
		long left = 0;
		long right = 0;
		for(int i = 0; i < q; i++){
			tmpArray = br.readLine().split(" ");

			//上記の理由により挿入箇所は問題にならない
			char c = tmpArray[1].charAt(0);
			long n = Long.parseLong(tmpArray[2]);

			if(c == '('){
				left += n;
			}
			else {
				right += n;
			}

			//判定
			if(right == left){
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}
