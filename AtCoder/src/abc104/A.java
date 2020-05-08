package abc104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		String result = "AGC";
		if(a < 1200){
			result = "ABC";
		}
		else if (a < 2800){
			result = "ARC";
		}

		System.out.println(result);
	}


}
