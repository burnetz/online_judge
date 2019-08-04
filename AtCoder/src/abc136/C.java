package abc136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] tmpArray = br.readLine().split(" ");
		
		int[] input = new int[n];
		
		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}
		
		String result = "Yes";
		//右から順に見ていく
		//右隣と同じか小さいなら操作するメリットが無いので
		//右隣と比べて大きいときだけ1小さくする
		for(int i = n - 2; i >= 0; i--){
			if(input[i] > input[i + 1]){
				input[i]--;
			}
			//小さくしてもなお大小が逆転しているときに条件を満たす
			if(input[i] > input[i + 1]){
				result = "No";
				break;
			}
		}
		
		System.out.println(result);
	}

}
