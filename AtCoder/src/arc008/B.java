package arc008;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		String name = sc.next();
		String kit = sc.next();

		int alpha[][] = new int[2][26];

		for(int i = 0; i < name.length(); i++){
			alpha[0][name.charAt(i) - 'A']++;
		}
		for(int i = 0; i < kit.length(); i++){
			alpha[1][kit.charAt(i) - 'A']++;
		}

		int result = 0;
		for(int i = 0; i < 26; i++){
			if(alpha[1][i] == 0){
				if(alpha[0][i] > 0){
					System.out.println(-1);
					return;
				}
				else {
					continue;
				}
			}

			result = Math.max(result, (alpha[0][i] + alpha[1][i] - 1)/alpha[1][i]);
		}

		System.out.println(result);
	}

}

