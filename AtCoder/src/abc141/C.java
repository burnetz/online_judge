package abc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]);
		int q = Integer.parseInt(tmpArray[2]);

		int points[] = new int[n];

		for(int i = 0; i < q; i++){
			int tmp = Integer.parseInt(br.readLine()) - 1;

			points[tmp]++;
		}

		//正解した数が分かれば正解できなかった数も分かるのでここで計算可能
		for(int i = 0; i < n; i++){
			int result = k - (q - points[i]);

			if(result > 0){
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

}
