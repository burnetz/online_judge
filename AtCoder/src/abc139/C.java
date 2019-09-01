package abc139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] tmpArray = br.readLine().split(" ");
		
		int[] h = new int[n + 1];
		
		for(int i = 0; i < n; i++){
			h[i] = Integer.parseInt(tmpArray[i]);
		}
		h[n] = Integer.MAX_VALUE;

		int result = 0;
		
		int tmpCount = 0;
		//下り坂の途中に正解はないのでひたすら右に進んでいけばいい
		for(int i = 0; i < n ; i++){
			if(h[i] >= h[i + 1]){
				tmpCount++;
			}
			else {
				result = Math.max(tmpCount, result);
				tmpCount = 0;
			}
			
		}
		
		System.out.println(result);

	}

}
