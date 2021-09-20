package codefes2016quala;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int k = sc.nextInt();

		char[] result = new char[str.length()];

		//前から順になるべくaを増やす（できないところでは何もしない方が良い）
		//余ったら最後の文字で使い切るというのが最善。
		for(int i = 0; i < str.length(); i++){
			char tmpC = str.charAt(i);

			if(tmpC == 'a'){
				result[i] = 'a';
				continue;
			}

			if(k >= 26 - (tmpC - 'a')){
				result[i] = 'a';
				k -= 26 - (tmpC - 'a');
			}
			else{
				result[i] = tmpC;
			}
		}

		k %= 26;

		result[str.length() - 1] = (char) ((result[str.length() - 1] - 'a' + k)%26 + 'a');

		System.out.println(result);
	}

}
