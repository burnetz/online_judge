package arc016;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] score = new char[n][9];

		for(int i = 0 ;i < n; i++){
			String str = sc.next();

			for(int j = 0 ; j < 9 ; j++){
				score[i][j] = str.charAt(j);
			}
		}

		int notes = 0;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < n; j++){
				if(score[j][i] == 'x'){
					notes++;
				}
				else if(score[j][i] == 'o' && (j == 0 || score[j - 1][i] != 'o')){
					notes++;
				}
			}
		}

		System.out.println(notes);
	}
}
