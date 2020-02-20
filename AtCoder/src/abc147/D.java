package abc147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long input[] = new long[n];
		String[] tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			input[i] = Long.parseLong(tmpArray[i]);
		}
		
		long result = 0;
		
		long[] bits = new long[128];
		long mask = 1;

		//重要なのはそれぞれの桁における0と1の個数
		for(int i = 0; i < 128; i++) {
			long ones = 0;
			for(int j = 0; j < n; j++) {
				if((mask & input[j]) != 0) {
					ones++;
				}
			}
			
			//各項において、0と1が1つずつの項しか1にならないので
			//0の個数*1の個数が足し算の結果になる
			bits[i] += ones * (n - ones);
			int k = 1;
			long mask2 = 2;
			//繰り上がりはここで考慮する
			while(bits[i] > 1) {
				if((bits[i] & mask2) != 0) {
					bits[i + k]++;
					bits[i] -= mask2;
				}
				
				k++;
				mask2 <<= 1;
			}
			
			mask <<= 1;
		}
		
		for(int i = 0; i < 128 ; i++) {
			result += bits[i] * (Math.pow(2, i)%1_000_000_007);
		}
		
		System.out.println(result % 1_000_000_007);
		
	}
}
