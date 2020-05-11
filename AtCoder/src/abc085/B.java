package abc085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int n = Integer.parseInt(input);

		int size[] = new int[n];
		for(int i = 0; i < n; i++){
			size[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(size);
		int result = 1;
		for(int i = 1; i < n; i++){
			if(size[i - 1] != size[i]){
				result++;
			}
		}

		System.out.println(result);
	}

}