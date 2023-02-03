package codefes2017quala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		String[] tmpArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);
		int k = Integer.parseInt(tmpArray[2]);
		
		boolean possible = false;
		
		if(n*m == k){
			possible = true;
		}
		
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < m; j++){
				int black = i*m - j*(i)+j*(n-i);
				
				if(black == k){
					possible = true;
				}
			}
		}
		
		if(possible){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
 
}
