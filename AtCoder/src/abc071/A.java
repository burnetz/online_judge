package abc071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int x = Integer.parseInt(tmpArray[0]);
		int a = Integer.parseInt(tmpArray[1]);
		int b = Integer.parseInt(tmpArray[2]);

		int xa = Math.abs(x-a);
		int xb = Math.abs(x-b);

		if(xa < xb){
			System.out.println("A");
		}
		else {
			System.out.println("B");
		}
	}

}