package agc037;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int dp[] = new int[str.length() + 1];
		dp[1] = 1;
		if(str.length() >= 2){
			if(str.charAt(0) == str.charAt(1)){
				dp[2] = 1;
			}
			else {
				dp[2] = 2;
			}
		}

		for(int i = 3; i <= str.length(); i++){
			if(str.charAt(i - 1) == str.charAt(i - 2)){
				dp[i] = dp[i - 3] + 2;
			}
			else {
				dp[i] = dp[i - 1] + 1;
			}

//			System.out.println(dp[i]);
		}

		System.out.println(dp[str.length()]);
	}

}
