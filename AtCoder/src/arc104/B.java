package arc104;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		//str[i]までの各文字の登場回数
		int charCount[][] = new int[4][n];
		for(int i = 0; i < n; i++){
			switch (str[i]){
			case 'A':
				charCount[0][i]++;
				break;
			case 'T':
				charCount[1][i]++;
				break;
			case 'C':
				charCount[2][i]++;
				break;
			case 'G':
				charCount[3][i]++;
				break;
			default:
			}

			if(i > 0){
				for(int j = 0; j < 4; j++){
					charCount[j][i] += charCount[j][i - 1];
				}
			}
		}

		int result = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				int a = charCount[0][j];
				int t = charCount[1][j];
				int c = charCount[2][j];
				int g = charCount[3][j];

				if(i > 0){
					a -= charCount[0][i - 1];
					t -= charCount[1][i - 1];
					c -= charCount[2][i - 1];
					g -= charCount[3][i - 1];
				}

//				System.out.println(a + " " + t + " " + c+" "+g);

				if(a == t && c == g){
					result++;
				}
			}
		}

		System.out.println(result);
	}
}