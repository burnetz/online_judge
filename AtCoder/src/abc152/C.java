package abc152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] tmpArray = br.readLine().split(" ");
		
		//low[i] i以下のインデックスで最小の入力値を保存
		int[] low = new int[n];
		int result = 1;
		
		low[0] = Integer.parseInt(tmpArray[0]);
		
		for(int i = 1; i < n; i++) {
			int tmp = Integer.parseInt(tmpArray[i]);
			
			if(tmp > low[i - 1]) {
				low[i] = low[i - 1];
			}
			else {
				low[i] = tmp;
				result++;
			}
		}
		
		System.out.println(result);
	}

}
