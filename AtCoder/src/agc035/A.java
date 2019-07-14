package agc035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] tmpArray = br.readLine().split(" ");

		long input[] = new long[n];

		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		Arrays.sort(input);

		//パターン1　全て0
		if(input[n - 1] == 0){
			System.out.println("Yes");
			return;
		}

		//ここから先はnが3の倍数である必要がある
		if(n % 3 == 0){
			//パターン2　あるxが1/3、他が0
			if(input[0] == 0 && input[n/3 - 1] == 0 && input[n/3] == input[n - 1]){
				System.out.println("Yes");
				return;
			}

			//パターン3　x^y^z=0となるx,y,zが均等枚数
			if(input[0] == input[n/3 - 1] && input[n/3] == input[2*n/3 - 1] && input[2*n/3] ==input[n - 1]
					&& (input[0]^input[n/3]^input[2*n/3]) == 0){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
