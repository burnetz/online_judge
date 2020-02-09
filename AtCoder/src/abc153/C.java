package abc153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]);
		
		int c[] = new int[n];
		tmpArray = br.readLine().split(" ");
		
		long sum = 0;
		for(int i = 0; i < n ; i++) {
			c[i] = Integer.parseInt(tmpArray[i]);
		}
		
		Arrays.sort(c);
		
		for(int i = 0; i < n - k; i++) {
			sum += c[i];
		}
		
		System.out.println(sum);
	}

}
