package abc245;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int input[][] = new int[2][n];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		//ok[i][j] : j番目にiを選んで条件を満たすかどうか
		boolean ok[][] = new boolean[2][n];
		ok[0][0] = true;
		ok[1][0] = true;
		
		//DPで解く。3重ループだがO(N)なので十分間に合う
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				for(int l = 0; l < 2; l++) {
					if(ok[l][i - 1] && Math.abs(input[j][i] - input[l][i - 1]) <= k) {
						ok[j][i] = true;
					}
				}
			}
		}
		
		if(ok[0][n - 1] || ok[1][n - 1]) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
