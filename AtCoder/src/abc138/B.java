package abc138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] tmpArray = br.readLine().split(" ");

		double A = 0;
		for(int i = 0; i < n; i++){
			int tmp = Integer.parseInt(tmpArray[i]);

			A += 1.0/tmp;
		}

		System.out.printf("%.6f\n", 1.0/A);

	}

}
