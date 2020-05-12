package abc077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		if(str1.charAt(0) == str2.charAt(2) && str1.charAt(1) == str2.charAt(1)
				&& str1.charAt(2) == str2.charAt(0)){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}

}