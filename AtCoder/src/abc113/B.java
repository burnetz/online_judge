package abc113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] tmpArray = br.readLine().split(" ");

		int t = Integer.parseInt(tmpArray[0]);
		int a = Integer.parseInt(tmpArray[1]);

		double temper[] = new double[n];

		tmpArray = br.readLine().split(" ");
		double dt = Double.MAX_VALUE;
		int index = -1;

		for(int i = 0; i < n; i++){
			int h = Integer.parseInt(tmpArray[i]);

			temper[i] = t - 0.006*h;

			if(dt > Math.abs(temper[i] - a)){
				dt = Math.abs(temper[i] - a);
				index = i;
			}
		}

		System.out.println(index + 1);
	}

}
