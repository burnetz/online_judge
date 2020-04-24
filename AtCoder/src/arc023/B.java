package arc023;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);


		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int input[][] = new int[r][c];

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				input[i][j] = sc.nextInt();
			}
		}

		int result = 0;
		//移動距離がちょうどの必要はない
		//余る分には行ったり来たりすればいいだけなので、偶奇のみを気にすればよい
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(i + j > d){
					break;
				}

				if(d%2 == (i + j)%2){
					result = Math.max(result, input[i][j]);
				}
			}
		}

		System.out.println(result);

	}
}
