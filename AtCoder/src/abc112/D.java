package abc112;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//下記の方法だとN=1のときが実は一番計算量が厳しい。ただし答えは明らかにM
		if(n == 1){
			System.out.println(m);
			return;
		}

		int result = 0;
		for(int i = 1; i <= m/n; i++){
			//i*nを引いた残りもまたiの倍数なら、それらのiを好きな項に配分すれば良いので題意を満たす
			if((m - i*n) % i == 0){
				result = i;
			}
		}

		System.out.println(result);
	}
}
