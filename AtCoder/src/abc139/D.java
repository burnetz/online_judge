package abc139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Integer.parseInt(br.readLine());

		//基本的にはi mod (i + 1)を計算しつつ
		//最後だけn mod 1（必ず0）とするのが効率が良い
		long result = n*(n - 1)/2;
		
		System.out.println(result);
	}

}
