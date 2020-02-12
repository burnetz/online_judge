package abc151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);
		
		boolean[] ac = new boolean[n + 1];
		int[] wa = new int[n + 1];
		int acCount = 0;
		int penalty = 0;
		
		for(int i = 0; i < m; i++) {
			tmpArray = br.readLine().split(" ");
			int p = Integer.parseInt(tmpArray[0]);
			String str = tmpArray[1];
			
			if(!ac[p]) {
				if(str.equals("AC")) {
					ac[p] = true;
					acCount++;
					penalty += wa[p];
				}
				else {
					wa[p]++;
				}
			}
		}
		
		System.out.println(acCount+" "+penalty);
	}

}
