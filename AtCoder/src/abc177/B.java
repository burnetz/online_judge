package abc177;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();

		int result = Integer.MAX_VALUE;

		for(int i = 0; i <= s.length - t.length; i++){
			int count = 0;
			for(int j = 0; j < t.length; j++){
				if(s[i + j] != t[j]){
					count++;
				}
			}

			result = Math.min(result, count);
		}

		System.out.println(result);
	}
}
