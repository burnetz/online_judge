package abc079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();

		int n = Integer.parseInt(tmp);

		long lucas[] = new long[n + 1];
		lucas[0] = 2;
		lucas[1] = 1;

		for(int i = 2; i <= n; i++){
			lucas[i] = lucas[i-1] + lucas[i-2];
		}

		System.out.println(lucas[n]);
	}

}