package arc073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int t = Integer.parseInt(tmpArray[1]);

		int input[] = new int[n];

		tmpArray = br.readLine().split(" ");

		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		//一人だけなら間違いなく答えはT
		if(n == 1){
			System.out.println(t);
			return;
		}
		int start = 0;

		long total = 0;
		for(int i = 1; i < n; i++){
			//前の人との間隔がT以上離れたならそこで清算
			if(input[i] - input[i - 1] > t){
				total += input[i - 1] + t - input[start];
				start = i;
			}

			//i == n - 1のときは未精算の区間について計算する必要がある
			if(i == n - 1) {
				total += input[i] + t - input[start];
			}

		}

		System.out.println(total);
	}

}
