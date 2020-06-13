package abc089;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int d = sc.nextInt();

		int x[] = new int[h*w + 1];
		int y[] = new int[h*w + 1];
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				int num = sc.nextInt();

				x[num] = j;
				y[num] = i;
			}
		}

		//事前に小さい数字からの累積コストを計算しておけば後で1クエリあたりO(1)で計算可能
		long costFromStart[] = new long[h*w + 1];

		for(int i = 1; i <= h*w ; i++){
			if(i <= d){
				costFromStart[i] = 0;
			}
			else{
				costFromStart[i] = costFromStart[i - d] + Math.abs(x[i] - x[i - d]) + Math.abs(y[i] - y[i - d]);
			}
		}

		int q = sc.nextInt();
		for(int i = 0; i < q; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();

			System.out.println(costFromStart[r] - costFromStart[l]);
		}
	}

}
