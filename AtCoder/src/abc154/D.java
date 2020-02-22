package abc154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]);
		
		int[] array = new int[n];
		
		tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(tmpArray[i]);
		}
		
		long total = 0;
		for(int i = 0; i < k; i++) {
			total += array[i];
		}
		
		long tmp = total;
	
		//合計の最大値が大きければ期待値も当然大きい
		//二重ループだと間に合わないのでしゃくとり法
		for(int i = 1; i + k <= n; i++) {
			tmp -= array[i - 1];
			tmp += array[i + k - 1];
			
			total = Math.max(tmp, total);
			
		}
		System.out.println((total + k)/2.0);
	}

}
