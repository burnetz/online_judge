package abc100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int d = Integer.parseInt(tmpArray[0]);
		int n = Integer.parseInt(tmpArray[1]);

		if(d == 0){
			if(n < 100) System.out.println(n);
			else {
				System.out.println(101);
			}
		}
		else {
			if(n == 100){
				System.out.println((int)(Math.pow(100, d)*101));
			}
			else {
				System.out.println((int)(Math.pow(100, d)*n));
			}
		}
	}
}
