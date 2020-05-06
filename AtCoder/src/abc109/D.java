package abc109;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int matrix[][] = new int[h][w];

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		int num = 0;
		StringBuffer sb = new StringBuffer();
		//左上から順に見ていき、
		//奇数枚なら1枚右に移す、既に右端なら1枚下に移すのが最適（道中は全て偶数になる）
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(matrix[i][j] % 2 == 1){
					if(i == h - 1 && j == w - 1){
						break;
					}
					num++;
					if(j != w - 1){
						matrix[i][j + 1]++;
						sb.append((i + 1) + " " + (j + 1) + " " + (i + 1) + " " + (j + 2) + "\n");
					}
					else {
						matrix[i + 1][j]++;
						sb.append((i + 1) + " " + (j + 1) + " " + (i + 2) + " " + (j + 1) + "\n");
					}
				}
			}
		}

		System.out.println(num);
		System.out.print(sb);

	}

}
