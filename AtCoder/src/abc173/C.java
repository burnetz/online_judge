package abc173;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		h = sc.nextInt();
		w = sc.nextInt();
		K = sc.nextInt();

		board = new char[h][w];

		for(int i = 0; i < h; i++){
			String str = sc.next();

			board[i] = str.toCharArray();
		}

		int result = 0;

		//全探索で十分間に合う
		for(int i = 0; i <= Math.pow(2, h) - 1; i++){
			int tmpI = i;
			boolean useH[] = new boolean[h];
			for(int j = 0; j < h; j++){
				if(tmpI % 2 == 1){
					useH[j] = true;
				}
				tmpI /= 2;
			}

			for(int j = 0; j <= Math.pow(2, w) - 1; j++){
				int tmpJ = j;
				boolean useW[] = new boolean[w];
				for(int k = 0; k < w; k++){
					if(tmpJ % 2 == 1){
						useW[k] = true;
					}
					tmpJ /= 2;
				}

				int count = 0;

				for(int k = 0; k < h; k++){
					for(int l = 0; l < w; l++){
						if(useH[k] == true && useW[l] == true && board[k][l] == '#'){
							count++;
						}
					}
				}

				if(count == K){
					result++;
				}
			}
		}

		System.out.println(result);
	}

	static int h;
	static int w;
	static int K;

	static char[][] board;
}