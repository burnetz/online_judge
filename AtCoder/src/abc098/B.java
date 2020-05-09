package abc098;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();

		int result = 0;
		for(int i = 1; i < str.length() - 1; i++){
			String x = str.substring(0, i);
			String y = str.substring(i);

			int tmp = 0;
			for(char c = 'a'; c <= 'z'  ; c++){
				if(x.indexOf(c) >= 0 && y.indexOf(c) >= 0){
					tmp++;
				}
			}

			result = Math.max(result, tmp);
		}

		System.out.println(result);
	}
}
