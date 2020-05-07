package abc106;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		long k = sc.nextLong();

		//そもそも2^5000兆の時点で余裕でlong型を超えている
		//元々1がk回以上連続している場合を除いて、最初に見た1以外の数字が答えになる
		for(int i = 0; i < k; i++){

			if(s.charAt(i) != '1'){
				System.out.println(s.charAt(i));
				return;
			}
		}

		System.out.println(1);
	}

}
