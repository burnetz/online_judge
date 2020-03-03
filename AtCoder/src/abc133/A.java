package abc133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int a = Integer.parseInt(tmpArray[1]);
		int b = Integer.parseInt(tmpArray[2]);

		System.out.println(Math.min(n*a, b));
	}

}
