package abc193;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		String s = sc.next();
		String t = sc.next();

		int digits[] = new int[10];
		Arrays.fill(digits, k);

		for(int i = 0; i < 4; i++){
			digits[s.charAt(i) - '0']--;
			digits[t.charAt(i) - '0']--;
		}

		//対戦の種類自体は81パターンしかないので十分間に合う
		long pattern = 0;
		for(int i = 1; i <= 9; i++){
			int resultT = calc(s, i);

			for(int j = 1; j <= 9; j++){
				int resultA = calc(t, j);

				if(resultT > resultA){
					//同じカードか違うカードかで計算が異なるので注意
					if(i != j){
						pattern += (long)digits[i]*digits[j];
					}
					else {
						pattern += (long)digits[i]*(digits[i] - 1);
					}
				}
			}
		}

		System.out.println((double)pattern/((long)(9*k - 8)*(9*k - 9)));
	}

	static int calc(String cards, int lastNum){
		int digits[] = new int[10];

		for(int i = 0; i < 4; i++){
			digits[cards.charAt(i) - '0']++;
		}
		digits[lastNum]++;

		int result = 0;

		for(int i = 1; i <= 9; i++){
			result += i * Math.pow(10, digits[i]);
		}
		return result;
	}

}
