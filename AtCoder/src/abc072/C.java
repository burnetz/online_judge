package abc072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());



		String[] tmpArray = br.readLine().split(" ");

		int[] input = new int[n];
		int[] index = new int[100001];
		Arrays.fill(index, -1);

		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(tmpArray[i]);
		}

		Arrays.sort(input);
		if(n == 1){
			System.out.println(1);
			return;
		}
		if(n == 2){
			if(input[1] - input[0] <= 2){
				System.out.println(2);
			}
			else {
				System.out.println(1);
			}
			return;
		}

		if(input[n - 1] - input[0] <= 2){
			System.out.println(n);
			return;
		}

		for(int i = 0; i < input.length ; i++){
			if(index[input[i]] == -1){
				index[input[i]] = i;
			}
		}

		for(int i = 1; i < index.length; i++){
			if(index[i] == -1 && index[i - 1] >= 0){
				index[i] = index[i - 1];
			}
		}

		int max = 0;
		for(int i = 0; i < index.length - 3 ; i++){

			int top = -1;
			int bottom = -1;

			if(index[i + 3] != -1){
				top = index[i + 3];
			}
			if(index[i] != -1){
				bottom = index[i];
			}
			if(bottom != -1 && top != -1 && max < top - bottom){
				max = top - bottom;
			}
		}

		System.out.println(max);
	}

}