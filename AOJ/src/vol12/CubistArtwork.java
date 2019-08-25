package vol12;

import java.util.Scanner;

public class CubistArtwork {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true){
			int w = sc.nextInt();
			int d = sc.nextInt();

			if(w == 0 && d == 0){
				break;
			}

			//要求される高さとしてそれぞれの数字が出た回数を数える
			int[] countw = new int[21];
			int[] countd = new int[21];

			for(int i = 0; i < w; i++){
				countw[sc.nextInt()]++;
			}

			for(int i = 0; i < d; i++){
				countd[sc.nextInt()]++;
			}


			int result = 0;
			//最適に配置した場合、それぞれの高さについて
			//横方向と奥行き方向のうち要求回数が多い方が採用される
			for(int i = 1; i <= 20; i++){
				result += Math.max(countw[i], countd[i])*i;
			}

			System.out.println(result);
		}
	}

}
