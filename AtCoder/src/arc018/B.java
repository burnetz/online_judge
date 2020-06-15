package arc018;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x[] = new int[n];
		int y[] = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				for(int k = j + 1; k < n; k++){
					long ax = x[j] - x[i];
					long ay = y[j] - y[i];
					long bx = x[k] - x[i];
					long by = y[k] - y[i];

					//外積の公式で平行四辺形の面積が出る
					//これを2で割り切れるなら三角形の面積も整数
					long area = (ax*by - bx*ay);
					if(area != 0 && area%2 == 0){
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}
}
