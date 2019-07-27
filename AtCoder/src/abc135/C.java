package abc135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] tmpArray = br.readLine().split(" ");
		
		int a[] = new int[n + 1];
		int b[] = new int[n];
		
		for(int i = 0; i < n + 1; i++){
			a[i] = Integer.parseInt(tmpArray[i]);
		}

		tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			b[i] = Integer.parseInt(tmpArray[i]);
		}
		
		long result = 0;
		//左から倒すだけ？
		for(int i = n - 1; i >= 0; i--){
			int right = Math.min(a[i + 1], b[i]);
			
			result += right;
			b[i] -= right;
			
			int left = Math.min(a[i], b[i]);
			
			result += left;
			a[i] -= left;
		}
		
		System.out.println(result);
	}

}
