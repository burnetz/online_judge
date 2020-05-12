package abc071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		String[] tmpArray = br.readLine().split(" ");
		int[] sticks = new int[tmpArray.length];
		for(int i = 0; i < tmpArray.length ; i++){
			sticks[i] = Integer.parseInt(tmpArray[i]);
		}

		System.out.println(makeRectangle(sticks));
	}

	static long makeRectangle(int[] sticks){
		Arrays.sort(sticks);
		int a = 0;
		int b = 0;
		int prev = -1;

		for(int i = sticks.length - 1; i >= 0 ; i-- ){
			if(prev == sticks[i]){
				if(a == 0){
					a = sticks[i];
					prev = -1;
					continue;
				}
				else {
					b = sticks[i];
					break;
				}
			}

			prev = sticks[i];
		}

		return (long)a*b;
	}

}