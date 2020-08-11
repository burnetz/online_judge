package vol13;

import java.util.Scanner;

public class GinkgoNumbers {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for(int i = 0; i < N; i++){
			int m = sc.nextInt();
			int n = sc.nextInt();

			int limit = m*m + n*n;

			int count = 0;
			//2つ目のヒントからm*m + n*n >= i*i + j*jであることが分かる。
			//m*m + n*n < 20000なのでループ回数はもっと絞れる
			for(int j = -1000 ; j <= 1000; j++){
				for(int k = -1000 ; k <= 1000; k++){
					if(j*j + k*k > limit){
						continue;
					}

					int tmp1 = j*m + k*n;
					int tmp2 = j*n - k*m;
					int div = j*j + k*k;
					if(div == 0){
						continue;
					}

					if(tmp1 % div == 0 && tmp2 % div == 0){
						count++;
					}
				}
			}

			if(count == 8){
				System.out.println("P");
			}
			else {
				System.out.println("C");
			}
		}
	}

}
