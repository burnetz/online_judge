package abc134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int d = Integer.parseInt(tmpArray[1]);

		int result = n / (2*d + 1);

		//余りが出るときは1人追加
		if(n % (2*d + 1) != 0){
			result++;
		}
		System.out.println(result);
	}

}
