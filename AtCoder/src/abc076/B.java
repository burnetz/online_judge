package abc076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int n = Integer.parseInt(input);
		int k = Integer.parseInt(br.readLine());

		int light = 1;
		for(int i = 0; i < n; i++){
			if(light > k){
				light += k;
			}
			else {
				light *= 2;
			}
		}

		System.out.println(light);

	}

}