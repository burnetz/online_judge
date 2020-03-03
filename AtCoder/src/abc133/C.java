package abc133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String[] tmpArray = br.readLine().split(" ");

		long l = Integer.parseInt(tmpArray[0]);
		long r = Integer.parseInt(tmpArray[1]);

		int result = 2019;
		for(long i = l; i < r && i <= l + 2019; i++){
			for(long j = i + 1; j <= r && j <= l + 2019; j++){
				result = Math.min(result, (int)((i*(j))%2019));
			}
		}

		System.out.println(result);

	}

}
