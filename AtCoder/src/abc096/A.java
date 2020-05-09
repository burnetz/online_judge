package abc096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmpArray = br.readLine().split(" ");

		int a = Integer.parseInt(tmpArray[0]);
		int b = Integer.parseInt(tmpArray[1]);

		int result = 0;
		for(int i = 1; i <= a; i++){
			for(int j = 1; j <= 31; j++){
				if(i == j){
					result++;
				}
				if(i == a && j == b){
					break;
				}
			}
		}

		System.out.println(result);
	}

}
