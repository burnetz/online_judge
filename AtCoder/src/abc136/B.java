package abc136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		int result = 0;
		
		//奇数桁でも偶数桁でも十分小さい桁についてはこれで計算できる
		for(int i = 1; i < input.length(); i += 2){
			result += 9*Math.pow(10, i - 1);
		}
		
		//奇数桁の場合は端数を追加
		if(input.length() % 2 == 1){
			result += n - Math.pow(10, input.length() - 1) + 1;
		}
		System.out.println(result);
	}

}
