package abc153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		
		int h = Integer.parseInt(tmpArray[0]);
		int n = Integer.parseInt(tmpArray[1]);
		
		int a[] = new int[n];
		tmpArray = br.readLine().split(" ");
		
		int sum = 0;
		for(int i = 0; i < n ; i++) {
			a[i] = Integer.parseInt(tmpArray[i]);
			sum += a[i];
		}
		
		if(sum >= h) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
