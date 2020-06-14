package abc114;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();

		//まずはひたすら素因数分解
		int count[] = new int[100];
		for(int i = 2; i <= d; i++){
			int n = i;
			int div = 2;

			while(n > 1){
				if(n%div == 0){
					n /= div;
					count[div]++;
				}
				else{
					div++;
				}
			}
		}

		int moreThan4 = 0;
		int moreThan2 = 0;
		int moreThan14 = 0;
		int moreThan24 = 0;

		for(int i = 0; i < count.length; i++){
			if(count[i] >= 4){
				moreThan4++;
			}
			if(count[i] >= 2){
				moreThan2++;
			}
			if(count[i] >= 14){
				moreThan14++;
			}
			if(count[i] >= 24){
				moreThan24++;
			}
		}

		//各素数の指数の積が75になるように選ぶ
		int result;
		if(moreThan4 >= 2 && moreThan2 >= 3){
			//5*5*3
			result = moreThan4*(moreThan4 - 1)/2 * (moreThan2 - 2);

			//15*5
			if(moreThan14 > 0){
				result += moreThan14*(moreThan4 - 1);
			}
			//25*3
			if(moreThan24 > 0){
				result += moreThan24*(moreThan2 - 1);
			}

			//ある素数だけで74乗が存在する場合。なお100!までなので2しか該当しない
			if(count[2] >= 74){
				result++;
			}
		}
		else {
			result = 0;
		}

		System.out.println(result);

	}

}
